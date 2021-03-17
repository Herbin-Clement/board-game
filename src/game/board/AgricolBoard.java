package game.board;

import game.tile.*;
import java.util.Arrays;

public class AgricolBoard extends Board{

    public AgricolBoard(int w, int h) {
        super(w,h);
    }

    private void displayBoard() {
        // String line = "";
        // for (int y = 0; y < this.getHeight(); y++) {
        //     for (int x = 0; x < this.getWidth(); x++) {
        //         if (board[x][y] instanceof OceanTile) {
        //             line += " .";
        //         } else {
        //             line += " X";
        //         }
        //         // } else if (board[x][y] instanceof MountainTile) {
        //         //     line += " M";
        //         // } else if (board[x][y] instanceof PlainTile) {
        //         //     line += " P";
        //         // } else if (board[x][y] instanceof DesertTile) {
        //         //     line += " D";
        //         // } else if (board[x][y] instanceof ForestTile) {
        //         //     line += " F";
        //         // }
        //     }
        //     System.out.println(line);
        //     line = "";
        // }
        String line = "";
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (board[x][y] instanceof OceanTile) {
                    line += " .";
                } else {
                    line += " X";
                }
                // } else if (board[x][y] instanceof MountainTile) {
                //     line += " M";
                // } else if (board[x][y] instanceof PlainTile) {
                //     line += " P";
                // } else if (board[x][y] instanceof DesertTile) {
                //     line += " D";
                // } else if (board[x][y] instanceof ForestTile) {
                //     line += " F";
                // }
            }
            System.out.println(line);
            line = "";
        }
    }

    public void initBoard() {
        int h = this.getWidth();
        int nbValues = h * h;
        int tab[][] = new int[h][h];
        for (int x = 0; x < h; x++) {
            for (int y = 0; y < h; y++) {
                tab[x][y] = 0;
            }
        }
        tab[0][0] = this.randomNumber(-h, h);
        tab[0][h - 1] = this.randomNumber(-h, h);
        tab[h - 1][0] = this.randomNumber(-h, h);
        tab[h - 1][h - 1] = this.randomNumber(-h, h);
        int i = h - 1;
        while (i > 1) {
            int id = (int) (i / 2);
            for (int x = id; x < h; x += i) {
                for (int y = id; y < h; y += i) {
                    int m = (tab[x - id][y - id] + tab[x - id][y + id] + tab[x + id][y + id] + tab[x + id][y - id]) / 4;
                    tab[x][y] = m + this.randomNumber(-id, id);
                }
            }
            int d = 0;
            for (int x = 0; x < h; x += id) {
                if (d == 0) {
                    d = id;
                } else {
                    d = 0;
                }
                for (int y = d; y < h; y += i) {
                    int s = 0;
                    int n = 0;
                    if (x >= id) {
                        s = s + tab[x - id][y];
                        n = n + 1;
                    }
                    if (x + id < h) {
                        s = s + tab[x + id][y];   
                        n = n + 1;
                    }
                    if (y >= id) {
                        s = s + tab[x][y - id];
                        n = n + 1;
                    }
                    if (y + id < h) {
                        s = s + tab[x][y + id];
                        n = n + 1;
                    }
                    tab[x][y] = s / n + this.randomNumber(-id, id);
                }
            }
            i = id;
        }
        int[] values = new int[nbValues];
        int count = 0;
        for (int k = 0; k < tab.length; k++) {
            for (int l = 0; l < tab.length; l++) {
                tab[k][l] = (int) Math.round(tab[k][l]);
                values[count] = tab[k][l];
                count += 1;
            }
        }
        Arrays.sort(values);
        for (int j = 0; j < values.length; j++) {
            values[j] += Math.abs(values[0]);
        }
        String line = "";
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (tab[x][y] < values[(int) nbValues * 67 / 100]) {
                    line += " .";
                } else if (tab[x][y] < values[(int) nbValues * 75 / 100]) {
                    line += " D";
                } else if (tab[x][y] < values[(int) nbValues * 83 / 100]) {
                    line += " P";
                } else if (tab[x][y] < values[(int) nbValues * 91 / 100]) {
                    line += " F";
                } else {
                    line += " M";
                }
            }
            System.out.println(line);
            line = "";
        }
    }
 
    public static void main(String[] args) {
        int l = 33;
        AgricolBoard board = new AgricolBoard(l, l);
        board.initBoard();
        // board.displayBoard();
    }
}