package game.player;



import java.util.ArrayList;

import game.board.Board;
import game.character.Worker;
import game.tile.*;
import game.exception.*;

public class AgricolPlayer extends Player{
    protected int ressource;
    /**
     * Create a player for the agricol game
     * @param n name of the player
     */
    public AgricolPlayer(String n){
        super(n,15,10);
        this.theCharacters = new ArrayList<Worker>(10);
        this.ressource = 0;
    }
    /**
     * @param b board of this game
     */
    public void deploy(Board b){
        CommonTile t = null;
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
     * feed all the workers
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
     * recolte the ressources of worker's tile
     */
    public void recolt(){
        for(Worker w : this.theCharacters){
            if(w.haveHarvest()){
                this.ressource += w.getPosition().getRessourceValue();
            }
        }
    }

    /**
     * choice of the AgricolPlayer between deploy a worker, change ressources to gold and do nothing
     * @param b board of this game
     */
    public void action(Board b){
        int number = (int) (Math.random()*2);
        if(number == 1) this.deploy(b);

        else if(number == 0) this.change();

        else{
            for(Worker worker : theCharacters){
                if(worker.getPosition() instanceof ForestTile || worker.getPosition() instanceof PlainTile){
                    this.gold += 1;
                }
                else if(worker.getPosition() instanceof DesertTile) {
                    this.gold += 2;
                }
            }
        }
    }

    /**
     * change ressourses to gold
     */
    public void change(){
        this.gold += this.ressource;
        this.ressource = 0;
    }
    
    /**
     * final score of the AgricolPlayer
     */
    public int score(){
        int score = 0;
        for(Worker worker : this.theCharacters){
            score += worker.getGold();
        }
        return score;
    }
}
