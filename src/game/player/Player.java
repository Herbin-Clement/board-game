package game.player;

/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public class Player {
    private String name;
    private int gold;
    private int numberOfCharacter; // ?? List de character car si le joeurs vole une unité a un autre joueurs  ct on fait 

    /**
     * Create a player
     * @param n name of the player 
     * @param g  quantity of gold
     * @param nbC  number of character that the player have 
     */
    public Player(String n, int g, int nbC) {
        this.name = n;
        this. gold = 0;
        this.numberOfCharacter = nbC;
    }

    /**
     * Return the name of the player
     * @return the name of the player 
     */
    public String getName(){
        return this.name;
    }
    /**
     * Return the quantituof gold
     * @return quantity of gold
     */
    public int getGold(){
        return this.gold;
    }
    /**
     * Return the number of Character
     * @return number of character 
     */
    public int getNbCharacter(){
        return this.numberOfCharacter;
    }


    public void deploy(){
    }

    public void action(){}
}

