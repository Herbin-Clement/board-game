package game;

import java.util.List;
import game.player.*;
import game.board.*;

public class Game {
    protected List<? extends Player> players;
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
        int i =1;
        boolean stop= false;
        Player maxPlayer = this.players.get(0);
        while(i<this.round && ! stop){
            System.out.println("it's round " + i + "!");
            for(Player player : this.players){
                System.out.println("it's " + player.getName() + "'s turn");
                player.action(this.board);
                player.recolt();
                player.feed();
            }
            if (this.board.allIsOccupated()){
                stop=true;
            }
            maxPlayer = this.computeScore(maxPlayer);
            i++;
        }
        System.out.println("the winner is " + maxPlayer.getName());
    }

    public Player computeScore(Player maxPlayer) {
        System.out.println("--------------------------------");
        for(Player player : this.players){
            int score = player.score();
            System.out.println("the score of " + player.getName() + " is " + score);
            if( score > maxPlayer.score()) maxPlayer = player;
        }
        System.out.println("--------------------------------");
        return maxPlayer;
    }
}
