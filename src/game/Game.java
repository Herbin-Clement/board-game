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
            System.out.println(String.format("\u001B[43m**** It's round %s ! ****\u001B[40m \n", i));
            for(Player player : this.players){
                System.out.println("\nIt's " + player.getName() + "'s turn");
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
        System.out.println("\nThe winner is " + maxPlayer.getName());
    }

    public Player computeScore(Player maxPlayer) {
        System.out.println("\n--------------------------------");
        for(Player player : this.players){
            int score = player.score();
            System.out.println("The score of " + player.getName() + " is " + score);
            if( score > maxPlayer.score()) maxPlayer = player;
        }
        System.out.println("-------------------------------- \n");
        return maxPlayer;
    }
}
