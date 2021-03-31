package game.tile;

import game.character.Army;

public class MountainTile extends CommonTile {
    

    /**
     * Create a mountain tile
     * @param x x coordinate 
     * @param y y coordinate 
     */
    public MountainTile(int x, int y, int c, int v) {
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
            return 5;
        }
    }

    /**
     * 
     * @return the number of soldier considered by the ennemy  on the tile
     */
    public int considerAs(){ // methode pour Army
        if(this.getCharacter() instanceof Army){
            Army army = (Army) this.getCharacter();
            return army.getNumber() + 2;
        }
        return 0;
        
    }

}
