package game;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

import game.board.*;
import game.player.*;
public class WarGame extends Game{

    public WarGame(WarBoard b){
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
            if(name.length() < 2) name += " ";
            p = new WarPlayer(name);
            wp.add(p);
        }
        this.players = wp;
    }
}
