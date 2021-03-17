package game.player;



import java.util.ArrayList;

import game.board.Board;
import game.character.Worker;
import game.tile.*;
import game.exception.*;

public class AgricolPlayer extends Player{

    /**
     * Create a player for the agricol game
     * @param n name of the player
     */
    public AgricolPlayer(String n){
        super(n,15,10);
        this.theCharacters = new ArrayList<Worker>(10);
    }
    /**
     * 
     */
    public void deploy(Board b){
        CommonTile t;
        boolean emptyTile = false;
        while(!emptyTile){
            try{
                t = this.chooseEmptyTile(b);
                emptyTile = true;
            }catch(TileNotEmptyException e){
            }
        }
        
        Worker worker = new Worker(t, this);
        t.setCharacter(worker);
        
    }

    /**
     * 
     */
    public void feed(){
        for(Worker w : this.theCharacters){
            if(this.gold - w.getGoldRequire()< 0){
                this.theCharacters.remove(w);
                this.gold = 0; // pour que la quantité d'or du joueur ne soit < 0 
            }
            else{
                this.gold -= w.getGoldRequire();
            }
        }

    }
    /**
     * 
     */
    public void recolt(){
        for(Worker w : this.theCharacters){
            if(w.haveHarvest()){
                this.gold += w.getPosition().getRessourceValue();
            }
        }
    }
}
