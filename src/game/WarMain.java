package game;

import java.util.ArrayList;
import java.util.List;

import game.board.WarBoard;
import game.player.WarPlayer;

public class WarMain{

    public static void main(String[] args) {
        WarBoard warboard = new WarBoard(10, 10);
        List<WarPlayer> wp = new ArrayList<WarPlayer>();
        for(String name : args){
            if(name.length() < 2) name += "_";
            wp.add(new WarPlayer(name));
        }
        Game game = new WarGame(wp, warboard);
        game.play();
    }

}