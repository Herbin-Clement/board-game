package game.exception;

public class TileNotEmptyException extends Exception{

    /**
     * create an error when the tile is not empty
     * @param s message of the error
     */
    public TileNotEmptyException(String s) {
        super(s);
    }

}
