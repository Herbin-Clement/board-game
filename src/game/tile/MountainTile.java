package game.tile;

<<<<<<< HEAD
public class MountainTile extends CommonTile {
=======
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class MountainTile extends Tile {
>>>>>>> 5d937eeef38474307ec89c25d9e0f1b18c847cad

    

    /**
     * Create a mountain tile
     * @param x x coordinate 
     * @param y y coordinate 
     */
    public MountainTile(int x, int y, int c, int v) {
        super(x, y, c, v, "stone");
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
