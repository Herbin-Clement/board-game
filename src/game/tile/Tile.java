package game.tile;

public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    /**
     * Create an ocean Tile
     * @param x x coordinate
     * @param y y coordinate
     */
    public Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    /**
     * Return the x coordinate of the Tile
     * @return the x coordinate
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Return the y coordinate of the Tile
     * @return the y coordinate 
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }
}
