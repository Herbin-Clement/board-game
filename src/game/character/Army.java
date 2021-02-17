package game.character;

import game.tile.*;

public class Army extends Character{
    private int number;
    private int foodRequire;
    private Player owner;
 
    public Army(Tile tile, int number) {
        super(tile);
        this.number = number;
        setFoodRequire();
    }

    public int getNumber() {
        return this.number;
    }

    public int getFood() {
        return this.foodRequire;
    }

    public Player getOwner(){}
        return this.owner;
    }
    public void setFoodRequire() {
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

    public void earnGold() {

    }
}
