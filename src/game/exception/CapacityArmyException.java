package game.exception;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class CapacityArmyException extends Exception{

    /**
     * create an error when the param entered for the number of soldier in the army in superior to 5
     * @param s message of the error
     */
    public CapacityArmyException(String s) {
        super(s);
    }

}
