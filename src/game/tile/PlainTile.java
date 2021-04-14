package game.tile;

import game.character.*;

public class PlainTile extends CommonTile {

    /**
     * Create a plain tile 
     * @param x x coordinate
     * @param y y coordinate
     * @param c c capacity
     * @param v v ressource value
     */
    public PlainTile(int x, int y, int c, int v) {
        super(x, y, c, v);
    }

    /**
     * @return food require on this tile
     */
    public int getFoodRequire(){
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber();
        } else if (this.getCharacter() instanceof Worker){
            return 1;
        } else {
            return 0;
        }
    }

    public String toString(){
        return "corn";
    }
}
