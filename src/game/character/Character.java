package game.character;

import game.tile.*;

public abstract class Character {
    protected int gold;
    protected Tile position;
    private Player owner;

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

    public Player getOwner(){}
        return this.owner;
}

    public void setOwner(Player p){
        this.owner = p;
}

    public abstract void earnGold();
}