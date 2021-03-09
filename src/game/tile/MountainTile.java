package game.tile;

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

    public String getRessource(){
        return RESSOURCE;
    }
}
