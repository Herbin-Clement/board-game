package game.character;

import game.tile.*;
import game.player.*;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon
 */
public abstract class Character {
    protected int gold;
    protected CommonTile position;
    private Player owner;

    /**
     * Create a character
     * @param o The owner of the character
     */
    Character(CommonTile tile, Player o) {
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
    public CommonTile getPosition(){
        return this.position;
    }
    /**
     * Set the character position
     * @param tile the new position 
     */
    public void setPosition(CommonTile tile) {
        this.position = tile;
    }
    /**
     * Return the Owner of the character
     * @return the Owner of the character
     */
    public Player getOwner(){
        return this.owner;
    }
    /**
     * Set the owner of the character
     * @param p the new Owner
     */
    public void setOwner(Player p){
        this.owner = p;
    }
    /**
     * Salary of the character
     * @param n quantity of gold added 
     */
    public abstract void earnGold(int n);
}