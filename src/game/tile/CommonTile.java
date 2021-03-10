package game.tile;



public class CommonTile extends Tile{
    private Character character;
    private int capacity;
    private int ressourceValue;
    private String ressource;
    
    /**
     * Create a tile
     * @param x x coordinate
     * @param y y coordinate
     */
    public CommonTile(int x, int y, int c, int v, String r) {
        super(x,y);
        this.character = null;
        this.capacity = c;
        this.ressourceValue = v;
        this.ressource = r;
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
    
    public String getRessource(){
        return this.ressource;
    }


}
