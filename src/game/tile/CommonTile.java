package game.tile;


import game.character.*;
import game.character.Character;

public abstract class CommonTile extends Tile {
    protected Character character;
    protected int capacity;
    protected int ressourceValue;
    
    
    /**
     * Create a tile
     * @param x x coordinate
     * @param y y coordinate
     * @param c c capacity
     * @param v v ressource value
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

    /**
     * @return the capacity of the tile
     */
    public int getCapacity(){
        return this.capacity;
    }

    /**
     * 
     * @return the ressource value of the tile
     */
    public int getRessourceValue(){
        return this.ressourceValue;
    }

    /**
     * 
     * @return the food require of thetile
     */
    public abstract int getFoodRequire();

    /**
     * 
     * @return the number of soldier considered by the ennemy  on the tile
     */
    public int considerAs(){ // methode pour Army
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber();
        }
        return 0;
        
    }

}
