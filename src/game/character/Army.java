package game.character;


import game.tile.*;
import game.player.*;
import game.exception.*;
import game.exception.TileCapacityException;
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

    /**
     * 
     * @return the food require
     */
    public int getFoodRequire(){
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
        this.setFoodRequire();// recalculer ici pour recalculer moins de fois qu'en le mettant dans Player
    }
    /**
     * Remove half warriors to the army
     */
    public void removeWarrior() {// il faut diviser par 2
        this.number =  this.number/2;
        this.setFoodRequire();
    }

    /**
     * gold earned
     * @param n gold to add
     */
    public void earnGold(int n){
        this.gold += n;
    }


    /**
     * meet potential army in adjacent tile
     * @param tile adjacent tile
     */
    public void meet(CommonTile tile){//creer equals
        if(!tile.isEmpty()){
            Army other = (Army) tile.getCharacter(); 
            if(tile.considerAs() < this.position.considerAs() && !this.getOwner().equals(other.getOwner())){ //armée ennemie inférieure
                this.fight(other);
            }
            else if(tile.considerAs() > this.position.considerAs() && this.getOwner().equals(other.getOwner())){ //alliées plus nombreux
                other.addWarrior(1);
                this.earnGold(1);
            }
        }
    }

    /**
     * consiquences between the deployement of the army next to an ennemy army
     * @param ennemy ennemy army 
     */
    public void fight(Army ennemy){
        if(ennemy.number>1){
            ennemy.removeWarrior();
        }
        else{
            ennemy.setOwner(this.getOwner());
        }
        this.earnGold(2);
    }

    /**
     * @param tile tile which have to accept the army
     * @exception TileCapacityException the tile can't contain the army
     */
    public void setPosition(CommonTile tile) throws TileCapacityException {
        if(tile.getCapacity() < this.getNumber()){
            throw new TileCapacityException("this tile can't contain this army");
        }
        this.position = tile;
    }


}
