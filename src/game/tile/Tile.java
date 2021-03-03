package game.tile;

import game.Ressource;

public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    private Character character;

    public Tile(int x, int y) {
        this.xCoordinate = x;
        this.yCoordinate = y;
        this.character = null;
    }
    /**
     * Return the x coordinate of the Tile
     * @return the x coordinate
     */
    public int getXCoordinate() {
        return this.xCoordinate;
    }

    /**
     * Return the y coordinate of the Tile
     * @return the y coordinate 
     */
    public int getYCoordinate() {
        return this.yCoordinate;
    }
    /**
     * Return the type of land of the Tile
     * @return the type of land
     */

    public Character getCharacter(){
        return this.character;
    }
    /**
     * 
     * @param c a character
     */
    public void setCharacter(Character c){
        this.character = c;
    }
    /**
     * Return if the tile is occupied by a Character
     * @return if the tile is occupied
     */
    public boolean isEmpty(){
        return this.character == null;
    }

}
