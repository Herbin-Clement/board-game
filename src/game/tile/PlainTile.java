package game.tile;

<<<<<<< HEAD
public class PlainTile extends CommonTile {
=======
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class PlainTile extends Tile {

    private static final String RESSOURCE = "barley";
    private int ressourceValue;
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad

    /**
     * Create a plain tile 
     * @param x x coordinate
     * @param y y coordinate
     */
    public PlainTile(int x, int y, int c, int v) {
        super(x, y, c, v, "barley");
    }



}
