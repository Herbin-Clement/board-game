package game.board;

import game.tile.*;

public class Board {
    private final int width;
    private final int height;
    private Tile[][] board;

    public Board(int w, int h) {
        this.width = w;
        this.height = h;
        this.board = new Tile[h][w];
    }

    /**
     * Create a board
     */
    public abstract void initBoard();

    public Tile getTile(int x, int y){
        return this.board[y][x];
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeigth(){
        return this.height;
    }
}
