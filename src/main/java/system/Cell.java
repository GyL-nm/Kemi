package system;

import reactions.*;
import substances.Empty;
import substances.Substance;
import substances.solid.movableSolid.MovableSolid;
import substances.solid.staticSolid.TempRadiator;
import substances.solid.staticSolid.StaticSolid;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Cell {
    int x;
    int y;

    final int JITTER_CONSTANT = 6;

    public double temperature; // room temp = 23

    public Substance substance;

    public static Cell newCellOfType(Class<? extends Substance> type, int x, int y, double temp) {
        try {
            return new Cell(type.getConstructor().newInstance(),x,y,temp);
        } catch (Exception ignored) { return null; }
    }

    public Cell(Substance substance, int x, int y, double temperature) {
        this.substance = substance;

        this.x = x; this.y = y;
        this.temperature = temperature;
    }

    public void step(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Cell>> adjacent = getAdjacentCells(cellMatrix);
        exchangeHeat(adjacent);
        phaseChange(cellMatrix, adjacent);
        react(cellMatrix, CellMatrix.flattenMatrix(adjacent));

        ArrayList<Cell> orderedAdjacent = getOrderedAdjacentCells(cellMatrix);
        move(cellMatrix, orderedAdjacent);
    }

    public ArrayList<ArrayList<Cell>> getAdjacentCells(CellMatrix cellMatrix) {
        ArrayList<ArrayList<Cell>> adjacent = new ArrayList<>();

        for (int row = y-1; row <= y+1; row++) {
            ArrayList newRow = new ArrayList<>();
            for (int col = x-1; col <= x+1; col++) {
                newRow.add(cellMatrix.getCell(col, row));
            }
            adjacent.add(newRow);
        }

        return adjacent;
    }

    public ArrayList<Cell> getOrderedAdjacentCells(CellMatrix cellMatrix) {
        ArrayList<Cell> adjacent = new ArrayList<>();

        for (int[] coord : substance.moveCandidateQueue()) {
            adjacent.add(cellMatrix.getCell(x+coord[0], y+coord[1]));
        }

        return adjacent;
    }

    private void move(CellMatrix cellMatrix, ArrayList<Cell> moveCandidates) {
        Random jitter = new Random();

        if (substance == null) return;
        if (substance instanceof StaticSolid) return;

        boolean canWander = true;
        if (substance instanceof MovableSolid) canWander = false;

        for (Cell moveCandidate : moveCandidates) {
            if (moveCandidate == null) continue;
//            if (moveCandidate.substance instanceof StaticSolid) continue;

            if ( cellMatrix.getCellSteppedBit(moveCandidate.x,moveCandidate.y) ) continue;

            if (moveCandidate.substance.properties.mass < substance.properties.mass) {
                if (moveCandidate.x == x && moveCandidate.y == y+1) { // if immediate below
                    cellMatrix.swapCells(this, moveCandidate);

                    cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x, y));
                    cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(moveCandidate.x, moveCandidate.y));

                } else if (moveCandidate.y == y+1) { // if below
                    if (jitter.nextInt(JITTER_CONSTANT) == 1) {
                        cellMatrix.swapCells(this, moveCandidate);

                        cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x,y));
                        cellMatrix.steppedBuffer.set( cellMatrix.steppedBitIndex(moveCandidate.x, moveCandidate.y) );
                    }
                } else { // if not below
                    if (canWander) {
                        if (moveCandidate.x == x - 1) { // if left
                            if (jitter.nextInt(JITTER_CONSTANT) == 1) {
                                cellMatrix.swapCells(this, moveCandidate);

                                cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x, y));
                                cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(moveCandidate.x, moveCandidate.y));
                            }
                        } else { // if right (increase odds to reduce left-side bias)
                            if (jitter.nextInt(JITTER_CONSTANT) == 1) {
                                cellMatrix.swapCells(this, moveCandidate);

                                cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(x, y));
                                cellMatrix.steppedBuffer.set(cellMatrix.steppedBitIndex(moveCandidate.x, moveCandidate.y));
                            }
                        }
                    }
                }
            }

//            if (    !(substance instanceof Solid)
//                    && belowCell.substance.getClass() == substance.getClass() // Fluids becoming less dense when they heat up
//                    && belowCell.temperature > temperature) {
//
//                cellMatrix.swapCells(this,belowCell);
//
//                return;
//            }
        }
    }

    public ArrayList<Cell> getSettleCandidates(ArrayList<ArrayList<Cell>> adjacent) { return null; }
    protected void settle(CellMatrix cellMatrix, ArrayList<Cell> settleCandidates) {}

    public void exchangeHeat(ArrayList<ArrayList<Cell>> adjacent) {
        if (substance instanceof TempRadiator) {
            return;
        }

        boolean bunsenAdjacent = false;
        double totalHeatExchanged = 0;
        for (ArrayList<Cell> row : adjacent) {
            for (Cell cell : row) {
                if (cell == null || cell == this) continue;

                double conductance = (cell.substance.properties.getHeatTransferFactor()+substance.properties.getHeatTransferFactor())/2.0;
                double heatExchanged = (cell.temperature - temperature) * conductance;

                double minTemp = Math.min(temperature,cell.temperature);
                double maxTemp = Math.max(temperature,cell.temperature);

                temperature += heatExchanged;
                temperature = Math.max(minTemp, Math.min(maxTemp, temperature));

                if (!(cell.substance instanceof TempRadiator)) {
                    cell.temperature -= heatExchanged;
                    cell.temperature = Math.max(minTemp, Math.min(maxTemp, cell.temperature));
                }
            }
        }
    }

    public Reaction phaseChange(CellMatrix cellMatrix, ArrayList<ArrayList<Cell>> adjacent) {
        for (PhaseChange phase : substance.phases) {
            if (phase.reactant() == null) {
                boolean passConditions = true;
                for (ReactionCondition condition : phase.conditions())
                    if (!condition.condition(this.temperature)) {
                        passConditions = false;
                        break;
                    }
                if (passConditions) {
                    cellMatrix.setCell(Objects.requireNonNull(
                            Cell.newCellOfType(phase.results()[0],
                                    this.x, this.y,
                                    this.temperature + phase.temperatureChange())));

                    return phase;
                }

            } else {
                for (ArrayList<Cell> row : adjacent) {
                    for (Cell cell : row) {
                        if (cell == null || cell == this) continue;

                        if (cell.substance.properties.getSubstanceReference() == Empty.class) {
                            boolean passConditions = true;
                            for (ReactionCondition condition : phase.conditions())
                                if (!condition.condition(this.temperature)) {
                                    passConditions = false;
                                    break;
                                }
                            if (passConditions) {
                                cellMatrix.setCell(Objects.requireNonNull(
                                        Cell.newCellOfType(phase.results()[0],
                                                this.x, this.y,
                                                this.temperature + phase.temperatureChange())));

                                cellMatrix.setCell(Objects.requireNonNull(
                                        Cell.newCellOfType(phase.results()[1],
                                                cell.x, cell.y,
                                                cell.temperature + phase.temperatureChange())));

                                return phase;
                            }
                        }
                    }
                }

                // fallback
                boolean passConditions = true;
                for (ReactionCondition condition : phase.conditions())
                    if (!condition.condition(this.temperature)) {
                        passConditions = false;
                        break;
                    }
                if (passConditions) {
                    cellMatrix.setCell(Objects.requireNonNull(
                            Cell.newCellOfType(phase.results()[0],
                                    this.x, this.y,
                                    this.temperature + phase.temperatureChange())));

                    return phase;
                }
            }
        }

        return null;
    }

    public Reaction react(CellMatrix cellMatrix, ArrayList<Cell> reactionCandidates) {
        for (Cell cell : reactionCandidates) {
            if (cell == null || cell.substance instanceof Empty) continue;
            Reaction reaction = ReactionReference.REACTION_MAP.get(this.substance.properties.getSubstanceReference(),cell.substance.properties.getSubstanceReference());
            ElectrolysisReaction electrolysisReaction = null;
            for (Reaction r : this.substance.reactions) {
                if (!(r instanceof ElectrolysisReaction)) continue;
                ElectrolysisReaction er = (ElectrolysisReaction) r;

                if (er.facilitator() == cell.substance.properties.getSubstanceReference()) {
                    electrolysisReaction = er;
                    break;
                }
            }
            if (electrolysisReaction != null) reaction = electrolysisReaction;
            if (reaction == null) continue;

            boolean passConditions = true;
            for (ReactionCondition condition : reaction.conditions())
                if (!condition.condition(this.temperature)) {
                    passConditions = false;
                    break;
                }
            if (passConditions) {
                if (reaction.results()[0] != null) cellMatrix.setCell(Objects.requireNonNull(
                        Cell.newCellOfType(reaction.results()[0],
                                this.x, this.y,
                                this.temperature + reaction.temperatureChange())));
                if (reaction.results()[1] != null) cellMatrix.setCell(
                        Objects.requireNonNull(Cell.newCellOfType(reaction.results()[1],
                                cell.x, cell.y,
                                cell.temperature + reaction.temperatureChange())));
                return reaction;
            }
        }
        return null;
    }

    public Cell setXY(int x, int y) { this.x = x; this.y = y; return this; }

    public int getX() { return x; }
    public int getY() { return y; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();

        String tempString = Double.toString((double) Math.round(temperature * 100) / 100);

        return out.append(substance)
                .append(" ("+ x + "," + y + ") ")
                .append(tempString +"°C").toString();
    }
}
