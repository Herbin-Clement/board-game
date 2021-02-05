package game;

public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    private Land typeOfLand;
    private Character character;

    public Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }
}
