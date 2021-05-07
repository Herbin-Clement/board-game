package game.player;



import java.util.*;

import game.board.Board;
import game.character.Worker;
import game.character.Character;
import game.tile.*;
import game.exception.*;

public class AgricolPlayer extends Player{
    protected int ressource;
    /**
     * Create a player for the agricol game
     * @param n name of the player
     */
    public AgricolPlayer(String n){
        super(n,15,10);
        this.ressource = 0;
        this.theCharacters = new ArrayList<>(10);
    }

    public int getRessource(){
        return this.ressource;
    }
    /**
     * @param b board of this game
     */
    public void deploy(Board b){
        CommonTile t = this.chooseEmptyTile(b);
        Worker worker = new Worker(t, this);
        t.setCharacter(worker);
        this.theCharacters.add(worker);
    }

    /**
     * feed all the workers
     */
    public void feed(){
        System.out.println("--------------------------------");
    	int i = 1;
        List<Character> copie;
        copie = List.copyOf(this.theCharacters);
        // System.out.println(String.format("taille theCharacters : %s", this.theCharacters.size()));
        // System.out.println("taille copy: " + copie.size());
        for(Character w : copie){
            if (this.getGold() < ((Worker) w).getGoldRequire()){
                System.out.println(String.format("worker %s was not payed. Worker left.", i));
                this.removeCharacter((Worker) w);
                w.getPosition().setCharacter(null);
                i++;
            }
            else{
                this.gold -=  ((Worker) w).getGoldRequire();
                System.out.println(String.format("Worker %s was payed. (%s gold)", i, ((Worker) w).getGoldRequire()));
                i++;
            }
        }
        System.out.println("--------------------------------\n");
        System.out.println(String.format("gold : %s, ressource : %s", this.gold, this.ressource));
    }

    /**
     * recolte the ressources of worker's tile
     */
    public void recolt(){
    	for(Character w : this.theCharacters){
            //if(((Worker) w).haveHarvest()){
            this.ressource += w.getPosition().getRessourceValue();
            //}
        }
    }

    /**
     * choice of the AgricolPlayer between deploy a worker, change ressources to gold and do nothing
     * @param b board of this game
     */
    public void action(Board b){
        int number = (int) (Math.random()*2);
        System.out.println(this.name + " choose " + number);
        if(number == 1) this.deploy(b); //deploit un ouvrier

        else if(number == 0) this.change(); // echange des ressources contre de l'or.

        else{ // ne rien faire
        	for(Character w : theCharacters){
                if(((Worker) w).getPosition() instanceof ForestTile || ((Worker) w).getPosition() instanceof PlainTile){
                    this.gold += 1;
                }
                else if(((Worker) w).getPosition() instanceof DesertTile) {
                    this.gold += 2;
                }
            }
        }
    }

    /**
     * change ressourses to gold
     */
    public void change(){
        this.gold += this.ressource;
        this.ressource = 0;
    }
    
    /**
     * final score of the AgricolPlayer
     */
    public int score(){
        int score = 0;
        for(Character w : this.theCharacters){
            score += ((Worker) w).getGold();
        }
        return score;
    }
}
