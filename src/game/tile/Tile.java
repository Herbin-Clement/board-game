package game.tile;

import game.Ressource;

public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    private Land typeOfLand;
    private Character character;

    public Tile(int x, int y, Land land) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.typeOfLand = land;
    }

    public int getXCoordinate() {
        return this.xCoordinate;
    }

    public int getYCoordinate() {
        return this.yCoordinate;
    }

    public Land getLand() {
        return this.typeOfLand;
    }


}
