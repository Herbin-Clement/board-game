package game.character;

import game.tile.*;
import game.player.*;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon
 */
public class Worker extends Character {
    private boolean haveHarvest;
    private int goldRequire;
    /**
     * Create a Worker
     * @param tile
     * @param o
     */
    public Worker(CommonTile tile, Player o) {
        super(tile, o);
        //this.haveHarvest = false; 
        this.goldRequire = this.position.getFoodRequire();
    }
    /*
    public boolean haveHarvest() {
        return this.haveHarvest;
    }
    
    public void harvest(){
        this.haveHarvest = true;
    }
    */
    /**
     * Return the quantity of gold necessary 
     * @return quantity of gold necessary 
     */
    public int getGoldRequire() {
        return this.goldRequire;
    }

    /**
     * pay of the worker
     */
    public void earnGold(int n) {
        this.gold += this.goldRequire;
    }

    public static void main(String[] args) {
        Worker w = new Worker(null, null);
        if (w instanceof Character) {
            System.out.println("oui");
        }
    }
}
