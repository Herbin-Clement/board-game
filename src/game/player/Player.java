package game.player;

import java.util.*;

import game.tile.*;
import game.character.Character;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public abstract class Player {

    private String name;
    private int gold;
    private List<Character> theCharacters ;  
    private int nbCharacter;

    /**
     * Create a player
     * @param n name of the player 
     * @param g  quantity of gold
     */
    protected Player(String n, int g, int c) {
        this.name = n;
        this. gold = 0;
        this.nbCharacter = c;
        this.theCharacters = new ArrayList<>();
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
     * 
     * @return the numnber of character that the player have
     */
    public int getNbCharacter(){
        return this.nbCharacter;
    }
    


    /**
     * Remove a caracter
     * @param c a character 
     */
    public void removeCharacter(Character c){
        this.theCharacters.remove(c);
    }

    /**
     * Deploy a Character on a specific Tile 
     * @param t A tile
     */
    public abstract void deploy(CommonTile t);


}