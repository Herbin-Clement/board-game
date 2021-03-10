package game.tile;

<<<<<<< HEAD
public class DesertTile extends CommonTile {
=======
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class DesertTile extends Tile {

    private static final String RESSOURCE = "sand";
    private int ressourceValue;
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad

    /**
     * Create a Desert Tile
     * @param x  x coordinate
     * @param y y coordiate
     */
    public DesertTile(int x, int y, int c, int v) {
        super(x, y, c, v, "sand");
    }
<<<<<<< HEAD

    
=======
    /**
     * Return the type of ressource present
     * @return the type of ressource present
     */
    public String getRessource(){
        return RESSOURCE;
    }
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad
}
