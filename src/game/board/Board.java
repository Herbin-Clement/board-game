package game.board;

import game.tile.*;

public abstract class Board {
    protected final int width;
    protected final int height;
    protected Tile[][] board;

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

    public int getHeight(){
        return this.height;
    }

    protected int randomNumber(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    
    protected int getWidthDiamondSquare(int w, int h) {
        int n = w <= h ? h : w;
        int p = 0;
        while (!(Math.pow(2, p - 1) + 1<= n && n <= Math.pow(2, p) + 1)) {
            p += 1;
        }

        return (int) Math.pow(2, p) + 1;
    }
}
