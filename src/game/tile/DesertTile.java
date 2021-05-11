package game.tile;
import game.character.*;

public class DesertTile extends CommonTile {
    /**
     * Create a Desert Tile
     * @param x  x coordinate
     * @param y y coordiate
     * @param c c capacity
     * @param v v ressource value
     */
    public DesertTile(int x, int y, int c, int v) {
        super(x, y, c, v);
    }

    /**
     * @return food require on this tile
     */
    public int getFoodRequire(){
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber()*2;
        } else {
            return 3;
        }
    }

    /**
     * compare this and o
     * @param o the other object to compare
     * @return true if this and o attributes are equal and false if not
     */
    public boolean equals(Object o){
        if (o instanceof DesertTile){
            DesertTile that = (DesertTile) o;
            return that.getXCoordinate() == this.getXCoordinate() && that.getYCoordinate() == this.getYCoordinate();
        } else return false;
    }

    /**
     * return the string representation of the tile
     */
    public String toString(){
        return "sand";
    }
}
