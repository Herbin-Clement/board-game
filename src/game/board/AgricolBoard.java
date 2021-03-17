package game.board;

import game.tile.*;

public class AgricolBoard extends Board{

    public AgricolBoard(int w, int h) {
        super(w,h);
    }

    public void initBoard() {
        int width = this.getWidth();
        int height = this.getHeight();
        int h = this.getArrayWidthDiamondSquare(width, height);
        System.out.println(String.format("diamond square (%s, %s) : %s", width, height, this.getWidthDiamondSquare(width, height)));

        int nbValues = width * height;
        int tempTab[][] = this.diamondSquare(h);

        int tab[][] = this.cutArray(width, height, tempTab);

        int[] values = this.getValues(tab, nbValues);
        
        this.board = this.getTileBoard(tab, values, nbValues, width, height);
    }
 
    private Tile[][] getTileBoard(int[][] tab, int[] values, int nbValues, int w, int h) {
        Tile[][] board = new Tile[w][h];
        int ocean = 0;
        int other = 0;
        String line = "";
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (tab[x][y] < values[(int) nbValues * 67 / 100] + 1) {
                    line += " .";
                    board[x][y] = new OceanTile(x, y);
                    ocean++;
                } else if (tab[x][y] < values[(int) nbValues * 76 / 100] + 1) {
                    line += " D";
                    board[x][y] = new DesertTile(x, y, 0, 0);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 84 / 100] + 1) {
                    line += " P";
                    board[x][y] = new PlainTile(x, y, 0, 0);
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 92 / 100] + 1) {
                    line += " F";
                    board[x][y] = new ForestTile(x, y, 0, 0);
                    other++;
                } else {
                    line += " M";
                    board[x][y] = new MountainTile(x, y, 0, 0);
                    other++;
                }
            }
            System.out.println(line);
            line = "";
        }
        int total = other + ocean;
        System.out.println(String.format("total : %s", total));
        System.out.println(String.format("ocean : %s = %s for 100", ocean, ocean * 100 / total));
        System.out.println(String.format("other : %s = %s for 100", other, other * 100 / total));
        if (ocean * 100 / total > 80) {
            this.initBoard();
        }
        return board;
    }
    public static void main(String[] args) {
        int w = 20;
        int h = 20;
        AgricolBoard board = new AgricolBoard(w, h);
        board.initBoard();
        board.displayBoard();
    }
}