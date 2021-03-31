package game.tile;

import game.character.Army;

public class ForestTile extends CommonTile {


    /**
     * Create a Forest Tile
     * @param x x coordinate
     * @param y y coordinate
     */
    public ForestTile(int x, int y, int c, int v) {
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
