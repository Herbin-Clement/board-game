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
    public Worker(Tile tile, Player o) {
        super(tile, o);
        this.haveHarvest = false; 
        if(this.position.getLand() == Land.MOUNTAIN){
            this.goldRequire = 5;
        }
        else if(this.position.getLand() == Land.DESERT){
            this.goldRequire = 3;
        }
        else {
            this.goldRequire = 1;
        }
    }
    /**
     * Return if the Worker have recolt ressources 
     * @return True iff the Worker have recolt ressources, false if not 
     */
    public boolean haveHarvest() {
        return this.haveHarvest;
    }
    /**
     * 
     */
    public void harvest(){
        this.haveHarvest = true;
    }
    /**
     * Return the quantity of gold necessary 
     * @return quantity of gold necessary 
     */
    public int getGoldRequire() {
        return this.goldRequire;
    }

    /**
     * 
     */
    public void earnGold(int n) {
        this.gold += this.goldRequire;
    }


}
