package game.character;

import game.tile.*;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon
 */
public abstract class Character {
    protected int gold;
    protected Tile position;
    private Player owner;

    /**
     * Create a character
     * @param o The owner of the character
     */
    Character(Tile tile, Player o) {
        this.position = tile;
        this.owner = o; 
        this.gold = 0;
    }
    /**
     * Return the quantity of gold of the character
     * @return quantity 
     */
    public int getGold() {
        return this.gold;
    }
    /**
     * Return the character position 
     * @return the character position
    */
    public Tile getPosition() {
        return this.position;
    }
    /**
     * Set the character position
     * @param tile the new position 
     */
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