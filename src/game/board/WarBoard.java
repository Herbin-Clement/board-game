package game.board;

import game.tile.*;

public class WarBoard extends Board {

    public WarBoard(int w, int h) {
        super(w,h);
    }

    public void initBoard(){
        int nbOfTile = this.getWidth() * this.getHeight();
    }
}