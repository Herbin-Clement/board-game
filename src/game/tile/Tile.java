package game.tile;

import game.Ressource;

public class Tile {
    private int xCoordinate;
    private int yCoordinate;
    private Character character;

    /**
     * Create a tile
     * @param x x coordinate
     * @param y y coordinate
     */
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
     * Set the character which on the tile
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
