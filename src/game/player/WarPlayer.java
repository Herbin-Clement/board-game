package game.player;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import game.exception.*;
import game.board.Board;
import game.character.Army;
import game.character.Character;
import game.tile.*;

public class WarPlayer extends Player{
    protected int food;

    /**
     * create a WarPlayer
     * @param n name of the WarPlayer
     */
    public WarPlayer(String n){
        super(n, 0, 35);
        this.food = 10;
        this.theCharacters = new ArrayList<>(35);
    }

    /**
     * 
     * @return the WarPlayer's food
     */
    public int getFood(){
        return this.food;
    }

    /**
     * recolte ressources on armies's tiles
     */
    public void recolt(){
        int food;
        System.out.println("--------------------------------");
        for(Character a : this.theCharacters){
            food = a.getPosition().getRessourceValue();
            System.out.println("recolt " + food + " of " + a.getPosition().toString());
            this.food += food;
        }
        System.out.println("--------------------------------\n");
    }

    /**
     * feed all his armies
     */
    public void feed(){
        System.out.println("--------------------------------");
        System.out.println(String.format("taille theCharacters : %s", this.theCharacters.size()));
    	int i = 1;
        List<Character> copie;
        copie = List.copyOf(this.theCharacters);
        System.out.println("taille copy: " + copie.size());
        for(Character a : copie){
            if (this.getFood() < ((Army) a).getFoodRequire()){
                System.out.println("army " + i + " was feed.");
                this.removeCharacter((Army) a);
                this.gold +=1;
                i ++;
            }
            else{
                System.out.println("army " + i + " was not feed. The army died.");
                this.food -=  ((Army) a).getFoodRequire();
                i ++;
            }
        }
        System.out.println("--------------------------------\n");
    }

    /**
     * deploy an army on a tile
     */
    public void deploy(Board b) {//decrementer nb de joueurs
        Army army = null;
        CommonTile t = null;
        boolean emptyTile = false;
        while(!emptyTile) { // choix d'une CommonTile vide
            try {
                t = this.chooseEmptyTile(b);
                emptyTile = true;
            } catch(TileNotEmptyException e) {
                System.out.println("la tuile n'est pas vide");
            }
        }

        boolean setp = false;
        List<CommonTile> liste = b.getAdjacentCommonTile(t);
        while(!setp) { // choix de la taille de l'armée possible pour la tuile
                 
            try {
                int number = (int) (Math.random()*4 +1);

                army = new Army(t, number, this);
            
                army.setPosition(t);
                t.setCharacter(army);
                setp = true;
                this.nbCharacter -= number;
            } catch(TileCapacityException e) {
                System.out.println("la tuile ne supporte pas l'armée");
            } catch (CapacityArmyException e) {
                
                System.out.println("L'armée n'a pas la bonne taille");
            }  
        }
        ((List<Character>)this.theCharacters).add( army); //ajout de l'armée dans la liste theCharatcter
        for(CommonTile c : liste){
            army.meet(c);
        }
    }

    /**
     * choice of the WarPlayer between deploy an army and do nothing
     * @param b board of this game
     */
    public void action(Board b) {
        int number;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("0 for doing nothing, 1 for deploy an army.");
            number = sc.nextInt();
            System.out.println(String.format("number : %s", number));
        } while (!(number <= 1 && number >= 0));
        if(number == 1) {
            System.out.println(this.getName() + " deploy an army !");
            this.deploy(b);
        } else {
            System.out.println(this.getName() + " decide to do nothing !");
        }
    }

    /**
     * @return final score of the WarPlayer
     */
    public int score() {
        int nbOfTerritory = 0;
        int score = 0;
        for(Character a : this.theCharacters) {
            nbOfTerritory ++;
            if( ((Army) a).getPosition() instanceof PlainTile) score += 1;
            else if ( ((Army) a).getPosition() instanceof ForestTile) score += 2;
            else score += 4;
        }
        if(nbOfTerritory >= 10) score += 5;

        return score + this.gold;
    }

}
