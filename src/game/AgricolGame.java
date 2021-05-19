package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import game.player.*;
import game.board.*;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class AgricolGame extends Game{

    /**
     * create a game
     * @param b board of the game
     */
    public AgricolGame(AgricolBoard b ){
        super(10);
        this.board = b;
    }

    /**
     * Setup the player, can choose the number of player and the name of each one
     */
    public void setupPlayer() {
        AgricolPlayer p;
        List<AgricolPlayer> wp = new ArrayList<AgricolPlayer>();
        int nbPlayer;
        String name;
        Scanner sc = new Scanner(System.in);
        System.out.println("How many player ? (Between 2 and 4)");
        nbPlayer = sc.nextInt();
        name = sc.nextLine();
        System.out.println(String.format("name : %s", name));
        for (int i = 0; i < nbPlayer; i++) {
            System.out.println("Name of player " + i + " :");
            name = sc.nextLine();
            if(name.length() < 2) name += " ";
            p = new AgricolPlayer(name);
            wp.add(p);
        }
        this.players = wp;
    }
}