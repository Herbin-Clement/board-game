package game.character;

import game.tile.*;

public class Worker extends Character{
    private boolean haveHarvest;
    private int goldRequire;

    public Worker(Tile tile) {
        super(tile);
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

    public boolean haveHarvest() {
        return this.haveHarvest;
    }

    public void harvest(){
        this.haveHarvest = true;
    }

    public int getGoldRequire(){
        return this.goldRequire;
    }

    public void earnGold(){
        this.gold += this.goldRequire;
    }


}
