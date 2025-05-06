package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class MatrixGraphic extends JPanel {
    BufferedImage image; int imageX,imageY = 0;
    int cellPixelSize;
    public Point hoveredCell;

    public int penSize;


    public MatrixGraphic(BufferedImage image, int x, int y, int cellPixelSize) {
        this.image = image;
        this.cellPixelSize = cellPixelSize;
        hoveredCell = null;
        imageX = x; imageY = y;

        penSize = 1;

        setPreferredSize(new Dimension(image.getWidth()+x, image.getHeight()+y) );
        setMaximumSize(new Dimension(image.getWidth()+x, image.getHeight()+y));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, imageX, imageY, this);

        paintCursor(g, Color.WHITE);
    }

    void paintCursor(Graphics g, Color c) {
        if (hoveredCell != null) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(c); // border color
            g2d.setStroke(new BasicStroke(1)); // border thickness
            g2d.drawRect(
                    ( (hoveredCell.x-penSize/2) *cellPixelSize)+imageX,
                    ( (hoveredCell.y-penSize/2) *cellPixelSize)+imageY,
                    cellPixelSize*penSize+1,
                    cellPixelSize*penSize+1
            );
        }
    }

    public void setImage(BufferedImage image) { this.image = image; }

    public Point getCellAtMouse(Point mouseCoordinates) {
        Point imageCoordinate = new Point(mouseCoordinates.x-imageX,mouseCoordinates.y-imageY);

        int col = imageCoordinate.y / cellPixelSize;
        int row = imageCoordinate.x / cellPixelSize;

        if (row >= 0 && row < image.getWidth()/cellPixelSize &&
                col >= 0 && col < image.getHeight()/cellPixelSize) {
            return new Point(row, col);
        }
        return null;
    }

    public void setHoveredCell(Point mouseCoordinates) {
        hoveredCell = getCellAtMouse(mouseCoordinates);
    }
}
