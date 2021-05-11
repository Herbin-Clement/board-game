package game;

import java.util.ArrayList;
import java.util.List;

import game.board.AgricolBoard;
import game.player.AgricolPlayer;

public class AgricolMain {

    public static void main(String[] args) {
        AgricolBoard agricolboard = new AgricolBoard(10, 10);
        List<AgricolPlayer> ap = new ArrayList<AgricolPlayer>();
        // for(String name : args){
        //     if(name.length() < 2) name += "_";
        //     ap.add(new AgricolPlayer(name));
        // }
        Game game = new AgricolGame(agricolboard);
        game.play();
    }
}
