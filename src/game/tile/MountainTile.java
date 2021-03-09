package game.tile;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class MountainTile extends Tile {

    private static final String RESSOURCE  = "stone";
    private int ressourceValue;
    

    /**
     * Create a mountain tile
     * @param x x coordinate 
     * @param y y coordinate 
     */
    public MountainTile(int x, int y, int c, int v) {
        super(x, y, c);
        this.ressourceValue = v;
    }

    /**
     * 
     * @return the value of the stone
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
