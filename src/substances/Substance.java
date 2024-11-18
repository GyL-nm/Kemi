package substances;

import system.CellMatrix;

public abstract class Substance {
    public int x;
    public int y;

    protected Substance(int x, int y) { this.setXY(x,y); }

    public abstract void step(CellMatrix cellMatrix);

    public int getX() { return x; }
    public int getY() { return y; }

    public void setXY(int x, int y) { this.x = x; this.y = y; }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        StringBuilder coords = new StringBuilder();
        coords.append(" (").append(this.x).append(",").append(this.y).append(") ");

        return out.append( this.getClass().getSimpleName() )
                .append(coords).toString();
    }
}
