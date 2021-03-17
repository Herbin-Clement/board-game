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
        int width = this.getWidth();
        int height = this.getHeight();
        int h = this.getWidthDiamondSquare(width, height);
        System.out.println(String.format("diamond square (%s, %s) : %s", width, height, this.getWidthDiamondSquare(width, height)));
        int nbValues = width * height;
        int tempTab[][] = new int[h][h];
        tempTab[0][0] = this.randomNumber(-h, h);
        tempTab[0][h - 1] = this.randomNumber(-h, h);
        tempTab[h - 1][0] = this.randomNumber(-h, h);
        tempTab[h - 1][h - 1] = this.randomNumber(-h, h);
        int i = h - 1;
        while (i > 1) {
            int id = (int) (i / 2);
            for (int x = id; x < h; x += i) {
                for (int y = id; y < h; y += i) {
                    int m = (tempTab[x - id][y - id] + tempTab[x - id][y + id] + tempTab[x + id][y + id] + tempTab[x + id][y - id]) / 4;
                    tempTab[x][y] = m + this.randomNumber(-id, id);
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
                        s = s + tempTab[x - id][y];
                        n = n + 1;
                    }
                    if (x + id < h) {
                        s = s + tempTab[x + id][y];   
                        n = n + 1;
                    }
                    if (y >= id) {
                        s = s + tempTab[x][y - id];
                        n = n + 1;
                    }
                    if (y + id < h) {
                        s = s + tempTab[x][y + id];
                        n = n + 1;
                    }
                    tempTab[x][y] = s / n + this.randomNumber(-id, id);
                }
            }
            i = id;
        }
        
        int tab[][] = new int[width][height];
        for (i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i < width && j < height) {
                    tab[i][j] = tempTab[i][j];
                }
            }
        }

        int[] values = new int[nbValues];
        int count = 0;
        for (int k = 0; k < width; k++) {
            for (int l = 0; l < height; l++) {
                tab[k][l] = (int) Math.round(tempTab[k][l]);
                values[count] = tempTab[k][l];
                count += 1;
            }
        }

        Arrays.sort(values);
        for (int j = 0; j < values.length; j++) {
            values[j] += Math.abs(values[0]);
        }
        int ocean = 0;
        int other = 0;
        String line = "";
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (tab[x][y] < values[(int) nbValues * 67 / 100] + 1) {
                    line += " .";
                    ocean++;
                } else if (tab[x][y] < values[(int) nbValues * 76 / 100]) {
                    line += " D";
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 84 / 100]) {
                    line += " P";
                    other++;
                } else if (tab[x][y] < values[(int) nbValues * 92 / 100]) {
                    line += " F";
                    other++;
                } else {
                    line += " M";
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
    }
 
    public static void main(String[] args) {
        int w = 20;
        int h = 20;
        AgricolBoard board = new AgricolBoard(w, h);
        board.initBoard();
        // board.displayBoard();
    }
}