package game;

import game.board.AgricolBoard;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class AgricolMain {

    public static void main(String[] args) {
        AgricolBoard agricolboard = new AgricolBoard(10, 10);
        Game game = new AgricolGame(agricolboard);
        game.setupPlayer();
        game.play();
    }
}
