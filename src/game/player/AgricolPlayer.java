package game.player;



import java.util.ArrayList;

import game.board.Board;
import game.character.Worker;
import game.tile.*;

public class AgricolPlayer extends Player{

    /**
     * Create a player for the agricol game
     * @param n name of the player
     */
    public AgricolPlayer(String n){
        super(n,15,10);
        this.theCharacters = new ArrayList<Worker>();
    }

    public void deploy(Board b){
        CommonTile t = this.chooseTile(b);
        Worker worker = new Worker(t, this);
        t.setCharacter(worker);
        
    }

    public void feed(){
        int total = 0;
        for(Worker w : this.theCharacters){
            total += w.getGoldRequire();
        }
        this.gold = this.gold - total;
    }

    public void recolt(){
        for(Worker w : this.theCharacters){
            this.gold += w.getPosition().getRessourceValue();
        }
    }
}
