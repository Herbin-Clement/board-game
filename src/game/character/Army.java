package game.character;

import java.lang.*;

import game.tile.*;
import game.player.*;
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
    public Army(CommonTile tile, int number, Player o) {
        super(tile, o);
        this.number = number;
        this.foodRequire = this.position.getRessource() == "sand" ? this.number * 2 : this.number;
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
        this.foodRequire = this.position.getRessource() == "sand" ? this.number * 2 : this.number;
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
     * Remove half warriors to the army
     */
    public void removeWarrior() {// il faut diviser par 2
        this.number = Math.floor(this.number/2);//etrange number est int pourtant
        setFoodRequire();// Pareil ici
    }
    public void earnGold(int n){
        this.gold += n;
    }



    public void fight(CommonTile tile){
        if(!tile.isEmpty()){
            Army ennemy = tile.getCharacter(); //probleme car de type Caracter...
            if(ennemy.number < this.number && !this.getOwner().equals(ennemy.getOwner())){
                if(ennemy.number>1){
                    ennemy.removeWarrior();
                }
                else{
                    ennemy.setOwner(this.getOwner());
                }
                this.earnGold(2);
            }
            else if(ennemy.number > this.number && this.getOwner().equals(ennemy.getOwner())){
                ennemy.addWarrior(1);//penser a vérifier que addWarrior vérifie les limites d'ajout
                this.earnGold(1);
            }
        }

    
    }



}
