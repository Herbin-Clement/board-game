package game.tile;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class PlainTile extends Tile {

    private static final String RESSOURCE = "barley";
    private int ressourceValue;

    /**
     * Create a plain tile 
     * @param x x coordinate
     * @param y y coordinate
     */
    public PlainTile(int x, int y, int c, int v) {
        super(x, y, c);
        this.ressourceValue = v;
    }

    /**
     * 
     * @return the value of the barley
     */
    public int getRessourceValue(){
        return this.ressourceValue;
    }

    public String getRessource(){
        return RESSOURCE;
    }
}
