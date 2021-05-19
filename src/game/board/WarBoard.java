package game.board;

import game.tile.*;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class WarBoard extends Board{

    public WarBoard(int w, int h) {
        super(w,h);
    }
 
    /**
     * 
     * @param tab array 
     * @param values array with all the values of tab
     * @param nbValues number of values 
     * @param w the width of the board
     * @param h the height of the board
     * @return
     */
    protected Tile[][] getTileBoard(int[][] tab, int[] values, int nbValues, int w, int h) {
        Tile[][] board = new Tile[w][h];
        int ocean = 0;
        int other = 0;
        // Change the int of the tab for Tile
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                 // if the value of the tab[x][y] is lower than the values[(int) nbValues * 67 / 100] + 1, set the tab[x][y] to a OceanTile
                // values[(int) nbValues * 67 / 100] is the value that 67% or more of the tile will be Ocean Tile
                if (tab[x][y] < values[(int) nbValues * 67 / 100] + 1) {
                    board[x][y] = new OceanTile(x, y);
                    ocean++;
                } else if (tab[x][y] < values[(int) nbValues * 76 / 100] + 1) {
                    board[x][y] = new DesertTile(x, y, 3, 0);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 84 / 100] + 1) {
                    board[x][y] = new PlainTile(x, y, 5, 5);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 92 / 100] + 1) {
                    board[x][y] = new ForestTile(x, y, 5, 1);
                    other++;
                } else {
                    board[x][y] = new MountainTile(x, y, 3, 0);
                    other++;
                }
            }
        }
        this.board = board;
        // this.displayBoard();
        // Test if all CommonTile have a neighbor, if not, replace the CommonTile for a OceanTile
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if (!(board[x][y] instanceof OceanTile)) {
                    if (!this.haveNeighbor(board, x, y)) {
                        board[x][y] = new OceanTile(x, y);
                        other--;
                        ocean++;
                    }
                }
            }
        }
        int total = other + ocean;
        // if the % of OceanTile is greater than 75%, return null and call initBoard()
        if (ocean * 100 / total > 75) {
            return null;
        }
        // set the capacity to the number of CommonTile of the board 
        this.capacity = other;
        return board;
    }
}