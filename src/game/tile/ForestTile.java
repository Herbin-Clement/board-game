package game.tile;

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
     * 
     * @return the value of the wood
     */
    public int getRessourceValue(){
        return this.ressourceValue;
    }

    public String getRessource(){
        return RESSOURCE;
    }
}
