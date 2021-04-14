package game;
import java.util.ArrayList;
import java.util.List;

import game.board.WarBoard;
import game.player.WarPlayer;

public class WarMain{

    public static void main(String[] args) {
        WarBoard warboard = new WarBoard(20, 20);
        WarPlayer p1 = new WarPlayer("Alexis");
        WarPlayer p2 = new WarPlayer("Lea");
        List<WarPlayer> wp = new ArrayList<WarPlayer>();
        wp.add(p1);
        wp.add(p2);
        Game game = new WarGame(wp, warboard);
        game.play();
    }

}