package game.board;

import game.tile.*;

public class AgricolBoard extends Board{

    public AgricolBoard(int w, int h) {
        super(w,h);
    }

    /**
     * Initialise the board with the five differents tiles
     */
    public void initBoard() {
        int width = this.getWidth();
        int height = this.getHeight();
        int h = this.getWidthDiamondSquare(width, height);
        System.out.println(String.format("diamond square (%s, %s) : %s", width, height, this.getWidthDiamondSquare(width, height)));

        int nbValues = width * height;
        int tempTab[][] = this.getArrayWithDiamondSquare(h);

        int tab[][] = this.cutArray(width, height, tempTab);

        int[] values = this.getValues(tab, nbValues);
        
        Tile[][] board = this.getTileBoard(tab, values, nbValues, width, height);
        if (board == null) {
            this.initBoard();
        } else {
            this.board = board;
        }
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
    private Tile[][] getTileBoard(int[][] tab, int[] values, int nbValues, int w, int h) {
        Tile[][] board = new Tile[w][h];
        int ocean = 0;
        int other = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (tab[x][y] < values[(int) nbValues * 67 / 100] + 1) {
                    board[x][y] = new OceanTile(x, y);
                    ocean++;
                } else if (tab[x][y] < values[(int) nbValues * 76 / 100] + 1) {
                    board[x][y] = new DesertTile(x, y, 1, 5);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 84 / 100] + 1) {
                    board[x][y] = new PlainTile(x, y, 1, 1);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 92 / 100] + 1) {
                    board[x][y] = new ForestTile(x, y, 1, 1);
                    other++;
                } else {
                    board[x][y] = new MountainTile(x, y, 1, 8);
                    other++;
                }
            }
        }
        this.board = board;
        this.displayBoard();
        for (int x = 0; x < this.width; x++) {
            for (int y = 0; y < this.height; y++) {
                if (!(board[x][y] instanceof OceanTile)) {
                    // System.out.println(String.format("(%s, %s)", x, y));
                    if (!this.haveNeighbor(board, x, y)) {
                        board[x][y] = new OceanTile(x, y);
                        other--;
                        ocean++;
                    }
                }
            }
        }
        int total = other + ocean;
        System.out.println(String.format("total : %s", total));
        System.out.println(String.format("ocean : %s = %s for 100", ocean, ocean * 100 / total));
        System.out.println(String.format("other : %s = %s for 100", other, other * 100 / total));
        if (ocean * 100 / total > 75) {
            return null;
        }
        return board;
    }
}