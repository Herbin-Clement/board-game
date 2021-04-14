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

    public boolean equals(CommonTile common){
        if (common instanceof DesertTile){
            DesertTile that = (DesertTile) common;
            return that.getXCoordinate() == this.getXCoordinate() && that.getYCoordinate() == this.getYCoordinate();
        }

        else return false;
    }

    public String toString(){
        return "sand";
    }
}
