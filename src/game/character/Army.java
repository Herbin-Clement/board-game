package game.character;

import game.tile.*;

public class Army extends Character{
    private int number;
    private int foodRequire;
    
 
    public Army(Tile tile, int number) {
        super(tile);
        this.number = number;
        this.foodRequire = this.position.getLand() == Land.DESERT ? this.number * 2 : this.number;
    }

    public int getNumber() {
        return this.number;
    }

    public int getFood() {
        return this.foodRequire;
    }


    public void setFoodRequire(){
        this.foodRequire = this.position.getLand() == Land.DESERT ? this.number * 2 : this.number;
    }

    public void addWarrior(int n) {
        this.number += n;
        setFoodRequire();
    }

    public void removeWarrior(int n) {
        this.number -= n;
        setFoodRequire();
    }

    public void earnGold(int n){
        this.gold += n;
    }
}
