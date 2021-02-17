package game.character;

import game.tile.*;

public class Worker extends Character{
    private boolean haveHarvest;
    public Worker(Tile tile) {
        super(tile);
        this.haveHarvest = false;
    }

    public boolean haveHarvest() {
        return this.haveHarvest;
    }

    public void earnGold(int n){
        
    }


}
