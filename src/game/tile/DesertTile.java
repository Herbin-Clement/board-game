package game.tile;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class DesertTile extends Tile {

    private static final String RESSOURCE = "sand";
    private int ressourceValue;

    /**
     * Create a Desert Tile
     * @param x  x coordinate
     * @param y y coordiate
     */
    public DesertTile(int x, int y, int c, int v) {
        super(x, y, c);
        this.ressourceValue = v;
    }

    /**
     * 
     * @return the value of the wood
     */
    public int getRessourceValue(){
        return this.ressourceValue;
    }
    /**
     * Return the type of ressource present
     * @return the type of ressource present
     */
    public String getRessource(){
        return RESSOURCE;
    }
}
