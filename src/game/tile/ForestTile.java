package game.tile;

import game.character.Army;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class ForestTile extends CommonTile {


    /**
     * Create a Forest Tile
     * @param x x coordinate
     * @param y y coordinate
     * @param c c capacity
     * @param v v ressource value
     */
    public ForestTile(int x, int y, int c, int v) {
        super(x, y, c, v);
    }

    /**
     * @return food require on this tile
     */
    public int getFoodRequire(){
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber();
        }
        else{
            return 1;
        }
    }

    /**
     * compare this and o
     * @param o the other object to compare
     * @return true if this and o attributes are equal and false if not
     */
    public boolean equals(Object o){
        if (o instanceof ForestTile){
            ForestTile that = (ForestTile) o;
            return that.getXCoordinate() == this.getXCoordinate() && that.getYCoordinate() == this.getYCoordinate();
        } else return false;
    }

    /**
     * return the string representation of the tile
     */
    public String toString(){
        return "wood";
    }
}
