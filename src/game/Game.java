package game;

import java.util.List;
import game.player.*;
import game.board.*;

public abstract class Game {
    protected List<? extends Player> players;
    protected Board board;
    protected int round;


    /**
     * create a game of round round
     * @param round
     */
    public Game(int round){
        this.round = round;
    }

    /**
     * get the number of the current round
     * @return the round
     */
    public int getRound(){
        return this.round;
    }

    /**
     * Play a game 
     */
    public void play(){
        int i =1;
        boolean stop= false;
        Player maxPlayer = this.players.get(0);
        while(i<this.round && ! stop){
            System.out.println("it's round " + i + "!\n");
            
            for(Player player : this.players){
                System.out.println("\nIt's " + player.getName() + "'s turn");
                this.board.displayBoard();
                player.action(this.board);
                player.recolt();
                player.feed();
            }
            if (this.board.allIsOccupated()){
                stop=true;
                System.out.println("hop la " + stop);
            }
            maxPlayer = this.computeScore(maxPlayer);
            i++;
        }
        System.out.println("\nThe winner is " + maxPlayer.getName());
    }

    /**
     * display the players score and return the player with the more scode
     * @param maxPlayer player
     * @return player
     */
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

    abstract public void setupPlayer();
}
