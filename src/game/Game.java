package game;

import java.util.List;
import game.player.*;
import game.board.*;

public class Game {
    protected List<Player> players;
    protected Board board;
    protected int round;

    public Game(int round){
        this.round = round;
    }

    public int getRound(){
        return this.round;
    }

//savoir ou mettre n
    /**
     * Play a game 
     */
    public void play(){
        int i =0;
        boolean stop= false;
        while(i<this.round && ! stop){
            for(Player player : this.players){
                player.action(this.board);
                player.recolt();
                player.feed();
            }
            if (this.board.allIsOccupated()){
                stop=true;
            }
            i++;
        }
        //ici calcul des points
    }
}
