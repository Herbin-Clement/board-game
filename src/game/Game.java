package game;

import java.util.List;
import game.player.*;
import game.board.*;

public class Game {
    private List<Player> players;
    private Board board;

    public Game(List<Player> players){
        this.players= players;
    }

//savoir ou mettre n
    /**
     * Play a game 
     */
    public void play(){
        int i =0;
        boolean stop= false;
        while(i<n && ! stop){
            for(Player player : this.players){
                player.action(this.board);
                player.recolte();
                player.feed();
            }
            if (this.board.allIsOccupated()){
                stop=true;
            }
            i++;
            player.daypass();
            //pas forcement utile si on gere deja dans feed()
        }
        //ici calcul des points
    }
}
