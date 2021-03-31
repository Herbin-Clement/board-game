package game.player;

import java.util.*;

import game.tile.*;
import game.board.Board;
import game.character.Character;

import game.exception.*;
/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis, Longatte Simon 
 * 
 */
public abstract class Player {

    protected String name;
    protected int gold;
    protected List<? extends Character> theCharacters ;  
    protected int nbCharacter;

    /**
     * Create a player
     * @param n name of the player 
     * @param g  quantity of gold
     */
    protected Player(String n, int g, int c) {
        this.name = n;
        this. gold = 0;
        this.nbCharacter = c;
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
     * @param b A board
     */
    public abstract void deploy(Board b);
    
    public CommonTile chooseEmptyTile(Board board) throws TileNotEmptyException {
        boolean found = false;
        Tile tile;
        CommonTile common = null;
        do {
            int numberX = (int) (Math.random()*board.getWidth());
            int numberY = (int) (Math.random()*board.getHeight());
            tile = board.getTile(numberX, numberY);
            if (tile instanceof CommonTile){
                common = (CommonTile) tile;
                found = true;
            }
        } while(!found);
        if(!common.isEmpty()){
            throw new TileNotEmptyException("the tile is not empty");
        }
        return common;
        
    }
    
    public abstract void feed();

    public abstract void recolt();

    public abstract void action(Board b);

    public abstract int score();
}