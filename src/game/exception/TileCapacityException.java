package game.exception;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class TileCapacityException extends Exception{
    
    /**
     * create an error when the number of soldiers is superior to the capacity of the tile
     * @param s message of the error
     */
    public TileCapacityException(String s) {
        super(s);
    }

}
