package game.board;

import game.tile.*;

public abstract class Board {
    private final int width;
    private final int height;
    private Tile[][] tiles;

    protected Board(int w, int h) {
        this.width = w;
        this.height = h;
        this.tiles = new Tile[h][w];
    }

    /**
     * Create a board
     */
    public abstract void initBoard();

    public Tile getTile(int x, int y){
        return this.tiles[y][x];
    }

    public int getWidth(){
        return this.width;
    }

    public int getHeight(){
        return this.height;
    }
}
