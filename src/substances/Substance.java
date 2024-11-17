package substances;

import system.CellMatrix;

public abstract class Substance {
    public int x;
    public int y;

    public abstract void step(CellMatrix cellMatrix);

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        StringBuilder coords = new StringBuilder();
        coords.append(" (").append(this.x).append(",").append(this.y).append(") ");

        return out.append( this.getClass().getSimpleName() )
                .append(coords).toString();
    }
}
