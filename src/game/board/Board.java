package game.board;

import game.tile.*;
import java.util.Arrays;

public abstract class Board {
    protected final int width;
    protected final int height;
    protected int capacity;
    protected int currentTilesUse;
    protected Tile[][] board;

    public Board(int w, int h) {
        this.width = w;
        this.height = h;
        this.capacity = 0;
        this.currentTilesUse = 0;
        initBoard();
    }

    /**
     * Create a board
     */
    public abstract void initBoard();

    /**
     * return true if all common tile are occupated
     * @return true if all common tile are occupated and false if not
     */
    public boolean allIsOccupated() {
        if (this.capacity == this.currentTilesUse) {
            return true;
        }
        return false;
    }

    public void addOrRemoveCurrentTilesUse(int i) {
        this.currentTilesUse += i;
    }



    /**
     * Display the board
     */
    public void displayBoard() {
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
    
    /**
     * 
     * @param x x coordonate of the tile
     * @param y y coordonate of the tile
     * @return return the (x,y) Tile
     */
    public Tile getTile(int x, int y){
        return this.board[y][x];
    }

    /**
     * 
     * @return the width of the board
     */
    public int getWidth(){
        return this.width;
    }

    /**
     * 
     * @return the height of the board
     */
    public int getHeight(){
        return this.height;
    }

    /**
     * return a random number between min and max
     * @param min the minimum of the return number
     * @param max the maximum of the return number
     * @return the random number
     */
    protected int randomNumber(int min, int max) {
        return (int) (Math.random() * ((max - min) + 1)) + min;
    }
    
    /**
     * get the width and height for the diamond square algorithm
     * @param w the width of the board
     * @param h the height of the board
     * @return the width / height value
     */
    protected int getWidthDiamondSquare(int w, int h) {
        int n = w <= h ? h : w;
        int p = 0;
        while (!(Math.pow(2, p - 1) + 1<= n && n <= Math.pow(2, p) + 1)) {
            p += 1;
        }
        return (int) Math.pow(2, p) + 1;
    }

    /**
     * create an array generate by the diamond square algorithm
     * @param h width and height of the arrays
     * @return an array generate by the diamond square algorithm
     */
    protected int[][] getArrayWithDiamondSquare(int h) {
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

    /**
     * cut the 2 dimmensional array generate by the diamond square algorithm into a smaller one
     * @param w width of the board
     * @param h height of the board
     * @param tempTab 2 dimmensional array generate by the diamond square algorithm
     * @return 2 dimensional array with the right proportions
     */
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

    /**
     * get an sorted array with the values of all cell
     * @param tab the tab where values are extract
     * @param nbValues the number of values
     * @return the array with values
     */
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

    /**
     * Check if the (x, y) tile have neighbor
     * @param board the board
     * @param x x coordinate of the tile
     * @param y y coordinate of the tile
     * @return true if (x,y) have neighbor and false if not
     */ 
    protected boolean haveNeighbor(Tile[][] board, int x, int y) {
        if (x - 1 >= 0) {
            if (!(board[x - 1][y] instanceof OceanTile)) {
                return true;
            }
        }
        if (x + 1 < this.getWidth()) {
            if (!(board[x + 1][y] instanceof OceanTile)) {
                return true;
            }
        }
        if (y - 1 >= 0) {
            if (!(board[x][y - 1] instanceof OceanTile)) {
                return true;
            }
        }
        if (y + 1 < this.getHeight()) {
            if (!(board[x][y + 1] instanceof OceanTile)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int w = 30;
        int h = 12;
        AgricolBoard board = new AgricolBoard(w, h);
        board.displayBoard();
    }

} 