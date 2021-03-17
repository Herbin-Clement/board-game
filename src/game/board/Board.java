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
    
    private int getWidthDiamondSquare(int n) {
        int p = 1;
        while (!(Math.pow(2, p - 1) < n && n < Math.pow(2, p))) {
            p += 1;
        }

        return p;
    }

    protected Tile randomTile(int x, int y) {
        int t = (int)(Math.random() * 4);
        if (t == 0) {
            return new MountainTile(x, y, 0, 0);
        } else if (t == 1) {
            return new PlainTile(x, y, 0, 0);
        } else if (t == 2) {
            return new ForestTile(x, y, 0, 0);
        }
        return new DesertTile(x, y, 0, 0);
    }
}
