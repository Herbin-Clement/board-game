package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import game.player.*;
import game.board.*;
public class AgricolGame extends Game{

    public AgricolGame(AgricolBoard b ){
        super(10);
        this.board = b;
    }

    public void setupPlayer() {
        WarPlayer p;
        List<WarPlayer> wp = new ArrayList<WarPlayer>();
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
            p = new WarPlayer(name);
            wp.add(p);
        }
        this.players = wp;
    }
}