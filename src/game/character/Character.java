package game.character;

import game.tile.*;

public abstract class Character {
    protected int gold;
    protected Tile position;

    Character(Tile tile) {
        this.position = tile;
        this.gold = 0;
    }

    public int getGold() {
        return this.gold;
    }

    public Tile getPosition() {
        return this.position;
    }

    public void setPosition(Tile tile) {
        this.position = tile;
    }

    public abstract void earnGold();
}