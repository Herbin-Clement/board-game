package game.character;

import game.tile.*;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class Army extends Character{
    private int number;
    private int foodRequire;
    
    /**
     * Create an Army composed of a given number of warrior
     * @param tile
     * @param number the number of warriors in the army
     */
    public Army(Tile tile, int number, Player o) {
        super(tile, o);
        this.number = number;
        this.foodRequire = this.position.getLand() == Land.DESERT ? this.number * 2 : this.number;
    }
    /**
     * Return the number of warriors in the army
     * @return the number of warriors in the army 
     */
    public int getNumber() {
        return this.number;
    }
    /**
     * Return the quantity of food necesarry to feed the army
     * @return the quantity of food necesarry to feed the army
     */
    public int getFood() {
        return this.foodRequire;
    }

    /**
     * Set the the foodRequire depending the land type
     */
    public void setFoodRequire(){
        this.foodRequire = this.position.getLand() == Land.DESERT ? this.number * 2 : this.number;
    }
    /**
     * Add n warriors to the army
     * @param n the number of warriors added 
     */
    public void addWarrior(int n) {
        this.number += n;
        setFoodRequire();// recalculer ici pour recalculer moins de fois qu'en le mettant dans Player
    }
    /**
     * Remove n warriors to the army
     * @param n
     */
    public void removeWarrior(int n) {// il faut diviser par 2
        this.number -= n;
        setFoodRequire();// Pareil ici
    }
    public void earnGold(int n){
        this.gold += n;
    }

    

    public void fight(Tile tile){
        
    }


}
