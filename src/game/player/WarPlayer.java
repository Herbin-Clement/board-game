package game.player;

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
        int i = 1;
        System.out.println("--------------------------------");
        for(Character a : this.theCharacters){
            food = a.getPosition().getRessourceValue();
            System.out.println(String.format("army %s recolt %s of %s", i, food, a.getPosition().toString()));
            this.food += food;
            i++;
        }
        System.out.println("--------------------------------\n");
    }

    /**
     * feed all his armies
     */
    public void feed(){
        System.out.println("--------------------------------");
    	int i = 1;
        List<Character> copie;
        copie = List.copyOf(this.theCharacters);
        // System.out.println(String.format("taille theCharacters : %s", this.theCharacters.size()));
        // System.out.println("taille copy: " + copie.size());
        for(Character a : copie){
            if (this.getFood() < ((Army) a).getFoodRequire()){
                System.out.println(String.format("army %s was not feed. army died.", i));
                this.removeCharacter((Army) a);
                a.getPosition().setCharacter(null);
                this.gold +=1;
                System.out.println(this.name + " +1 gold");
                i++;
            }
            else{
                this.food -=  ((Army) a).getFoodRequire();
                System.out.println(String.format("army %s was feed. (%s food)", i, ((Army) a).getFoodRequire()));
                i++;
            }
        }
        System.out.println("--------------------------------\n");
        System.out.println(String.format("gold : %s, food : %s", this.gold, this.food));
    }

    /**
     * deploy an army on a tile
     */
    public void deploy(Board b) {//decrementer nb de joueurs + faire 3 fonctions
        if(this.getNbCharacter() > 0){
            Army army = null;
            CommonTile tile = null;
            tile = this.chooseEmptyTile(b);
            army = putGoodArmy(tile);// choix d'une armée adaptée
            List<CommonTile> liste = b.getAdjacentCommonTile(tile);
            
            ((List<Character>)this.theCharacters).add(army); //ajout de l'armée dans la liste theCharatcter
            for(CommonTile c : liste){
                army.meet(c);
            }
        }
        else System.out.println("You deployed all your soldiers.");
    }

    public Army putGoodArmy(CommonTile tile) {
        Army army;  
        int number;               
        try {
            number = (int) (Math.random()*4 +1);
            System.out.println("army of size " + number + " is created.");
            army = new Army(tile, number, this);
            
            army.setPosition(tile);
            tile.setCharacter(army);
            this.nbCharacter -= number;
        } catch(TileCapacityException e) {
            System.out.println("La tuile ne supporte pas l'armée");
            army = putGoodArmy(tile);
        } catch (CapacityArmyException e) {
            System.out.println("L'armée n'a pas la bonne taille");
            army = putGoodArmy(tile);
        } 
        return army;
    }

    /**
     * choice of the WarPlayer between deploy an army and do nothing
     * @param b board of this game
     */
    public void action(Board b) {
        int number;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("0 for doing nothing, 1 for deploy an army. Your choice : ");
            number = sc.nextInt();
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
