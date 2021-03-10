package game.tile;

<<<<<<< HEAD
public class ForestTile extends CommonTile {
    

=======
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 *
 */
public class ForestTile extends Tile {
    private static final String RESSOURCE  = "wood"
    private int ressourceValue;
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad

    /**
     * Create a Forest Tile
     * @param x x coordinate
     * @param y y coordinate
     */
    public ForestTile(int x, int y, int c, int v) {
<<<<<<< HEAD
        super(x, y, c, v, "wood");
    }

=======
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
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad
}
