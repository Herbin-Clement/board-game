package game.tile;


import game.character.Character;

public abstract class CommonTile extends Tile{
    private Character character;
    private int capacity;
    private int ressourceValue;
    
    
    /**
     * Create a tile
     * @param x x coordinate
     * @param y y coordinate
     */
    protected CommonTile(int x, int y, int c, int v) {
        super(x,y);
        this.character = null;
        this.capacity = c;
        this.ressourceValue = v;
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

    public int getCapacity(){
        return this.capacity;
    }

    public int getRessourceValue(){
        return this.ressourceValue;
    }

    public abstract int getFoodRequire();

}
