package game.tile;
import game.character.*;

public class DesertTile extends CommonTile {
    /**
     * Create a Desert Tile
     * @param x  x coordinate
     * @param y y coordiate
     */
    public DesertTile(int x, int y, int c, int v) {
        super(x, y, c, v);
    }

    public int getFoodRequire(){
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber()*2;
        }
        else{
            return 3;
        }
    }
}
