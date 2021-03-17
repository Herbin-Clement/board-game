package game.character;


import game.tile.*;
import game.player.*;
import game.exception.*;
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
    public Army(CommonTile tile, int number, Player o) throws CapacityArmyException{
        super(tile, o);
        if(number > 5){
            throw new CapacityArmyException("An Army can contain until 5 soldiers");
        }
        else{
            this.number = number;
        }
        this.foodRequire = this.position.getFoodRequire();
    }
    /**
     * Return the number of warriors in the army
     * @return the number of warriors in the army 
     */
    public int getNumber() {
        return this.number;
    }

    public int getFoodRequire(){
        return this.foodRequire;
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
        this.foodRequire = this.position.getFoodRequire();
    }
    /**
     * Add n warriors to the army
     * @param n the number of warriors added 
     */
    public void addWarrior(int n) {
        int maxNb = this.position.getCapacity();
        if(this.number + n <= maxNb){
            this.number += n;
        }
        else{
            this.number = maxNb;
        }
        setFoodRequire();// recalculer ici pour recalculer moins de fois qu'en le mettant dans Player
    }
    /**
     * Remove half warriors to the army
     */
    public void removeWarrior() {// il faut diviser par 2
        this.number =  this.number/2;//etrange number est int pourtant
        setFoodRequire();// Pareil ici
    }
    public void earnGold(int n){
        this.gold += n;
    }



    public void meet(CommonTile tile){//creer equals
        if(!tile.isEmpty()){
            Army other = (Army) tile.getCharacter(); 
            if(other.number < this.number && !this.getOwner().equals(other.getOwner())){ //armée ennemie inférieure
                this.fight(other);
            }
            else if(other.number > this.number && this.getOwner().equals(other.getOwner())){ //alliées plus nombreux
                other.addWarrior(1);
                this.earnGold(1);
            }
        }
    }

    public void fight(Army ennemy){
        if(ennemy.number>1){
            ennemy.removeWarrior();
        }
        else{
            ennemy.setOwner(this.getOwner());
        }
        this.earnGold(2);
    }

    public void setPosition(CommonTile tile)throws TileCapacityException{
        if(tile.getCapacity() < this.getNumber()){
            throw new TileCapacityException("this tile can't contain this army");
        }
        this.position = tile;
    }


}
