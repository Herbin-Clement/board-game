package game.tile;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 *
 */
public class ForestTile extends Tile {
    private static final String RESSOURCE  = "wood"
    private int ressourceValue;

    /**
     * Create a Forest Tile
     * @param x x coordinate
     * @param y y coordinate
     */
    public ForestTile(int x, int y, int c, int v) {
        super(x, y, c);
        this.ressourceValue = v;
    }

    /**
     * Return the number of ressource when a character recolt it
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
