package game.exception;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class TileNotEmptyException extends Exception{

    /**
     * create an error when the tile is not empty
     * @param s message of the error
     */
    public TileNotEmptyException(String s) {
        super(s);
    }

}
