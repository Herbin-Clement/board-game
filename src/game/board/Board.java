package game.board;

import game.tile.*;
import java.util.Arrays;

public abstract class Board {
    protected final int width;
    protected final int height;
    protected Tile[][] board;

    public Board(int w, int h) {
        this.width = w;
        this.height = h;
        initBoard();
    }

    /**
     * Create a board
     */
    public abstract void initBoard();

    private void displayBoard() {
        String line = "";
        for (int y = 0; y < this.getHeight(); y++) {
            for (int x = 0; x < this.getWidth(); x++) {
                if (this.board[x][y] instanceof OceanTile) {
                    line += " .";
                } else if (this.board[x][y] instanceof MountainTile) {
                    line += " M";
                } else if (this.board[x][y] instanceof PlainTile) {
                    line += " P";
                } else if (this.board[x][y] instanceof DesertTile) {
                    line += " D";
                } else if (this.board[x][y] instanceof ForestTile) {
                    line += " F";
                }
            }
            System.out.println(line);
            line = "";
        }
    }

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

    protected int[][] diamondSquare(int h) {
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
        return tempTab;
    }

    protected int[][] cutArray(int w, int h, int[][] tempTab) {
        int tab[][] = new int[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                if (i < width && j < height) {
                    tab[i][j] = (int) Math.round(tempTab[i][j]);
                    
                }
            }
        }
        return tab;
    }

    protected int[] getValues(int[][] tab, int nbValues) {
        int[] values = new int[nbValues];
        int count = 0;
        for (int k = 0; k < width; k++) {
            for (int l = 0; l < height; l++) {
                values[count] = tab[k][l];
                count += 1;
            }
        }
        Arrays.sort(values);
        return values;
    }

} 
