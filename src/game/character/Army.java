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
        setFoodRequire();// recalculer ici pour recalculer moins de fois qu'en le mettant dans Player
    }

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
