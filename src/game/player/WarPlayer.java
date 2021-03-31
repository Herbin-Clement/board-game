package game.player;

import java.util.ArrayList;

import game.exception.*;
import game.board.Board;
import game.character.Army;
import game.tile.*;

public class WarPlayer extends Player{
    protected int food;

    /**
     * create a WarPlayer
     * @param n name of the WarPlayer
     */
    public WarPlayer(String n){
        super(n, 0, 35);
        this.food = 10;
        this.theCharacters = new ArrayList<Army>(35);
    }

    /**
     * 
     * @return the WarPlayer's food
     */
    public int getFood(){
        return this.food;
    }

    /**
     * recolte ressources on armies's tiles
     */
    public void recolt(){
        for(Army a : this.theCharacters){
            this.food += a.getPosition().getRessourceValue();
        }
    }

    /**
     * feed all his armies
     */
    public void feed(){
        for (Army army : this.theCharacters){
            if (getFood() < army.getFoodRequire()){
                this.removeCharacter(army);
                this.gold +=1;
            }
            else{
                this.food -= army.getFoodRequire();
            }
        }
    }

    /**
     * deploy an army on a tile
     */
    public void deploy(Board b){
        Army army;
        CommonTile t;
        boolean emptyTile = false;
        while(!emptyTile){ // choix d'une CommonTile vide
            try{
                t = this.chooseEmptyTile(b);
                emptyTile = true;
            }catch(TileNotEmptyException e){
            }
        }

        boolean setp = false;
        ArrayList<CommonTile> liste = b.getAdjacentCommonTile(t);
        while(!setp){ // choix de la taille de l'armée possible pour la tuile
                 
            try{
                int number = (int) (Math.random()*4 +1);
                army = new Army(t, number, this);
            
                army.setPosition(t);
                t.setCharacter(army);
                setp = true;
            }catch(TileCapacityException e){
            }  
        }
        this.theCharacters.add(army); //ajout de l'armée dans la liste theCharatcter
        for(CommonTile c : liste){
            army.meet(c);
        }
    }

    /**
     * choice of the WarPlayer between deploy an army and do nothing
     * @param b board of this game
     */
    public void action(Board b){
        int number = (int) (Math.random()*1);
        if(number == 1) this.deploy(b);
    }

    /**
     * @return final score of the WarPlayer
     */
    public int score(){
        int nbOfTerritory = 0;
        int score = 0;
        for(Army army : this.theCharacters){
            nbOfTerritory ++;
            if(army.getPosition() instanceof PlainTile) score += 1;
            else if (army.getPosition() instanceof ForestTile) score += 2;
            else score += 4;
        }
        if(nbOfTerritory >= 10) score += 5;

        return score + this.gold;
    }

}
