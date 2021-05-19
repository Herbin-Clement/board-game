package game;

import game.board.WarBoard;

public class WarMain{

    public static void main(String[] args) {
        WarBoard warboard = new WarBoard(10, 10);
        Game game = new WarGame(warboard);
        game.setupPlayer();
        game.play();
    }

}