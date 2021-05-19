package game.tile;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class OceanTile extends Tile{
    /**
     * create ocean tile
     * @param x x cordinate 
     * @param y y cordinate
     */
    public OceanTile(int x, int y){
        super(x,y);
    }

    /**
     * return the string representation of the tile
     */
    public String toString(){
        return "ocean";
    }
}
