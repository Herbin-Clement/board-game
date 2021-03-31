package game.tile;

import game.character.Army;

public class PlainTile extends CommonTile {

    /**
     * Create a plain tile 
     * @param x x coordinate
     * @param y y coordinate
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
        }
        else{
            return 1;
        }
    }
}
