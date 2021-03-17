package game.player;

import java.util.ArrayList;

import game.exception.*;
import game.board.Board;
import game.character.Army;
import game.exception.DeployException;
import game.tile.*;

public class WarPlayer extends Player{
    protected int food;

    public WarPlayer(String n){
        super(n, 0, 35);
        this.food = 10;
        this.theCharacters = new ArrayList<Army>(35);
    }

    public int getFood(){
        return this.food;
    }

    public void recolt(){
        for(Army a : this.theCharacters){
            this.food += a.getPosition().getRessourceValue();
        }
    }

    public void feed(){
        for (Army army : theCharacters){
            if (getFood() < army.getFoodRequire()){
                this.removeCharacter(army);
                this.gold +=1;
            }
            else{
                this.food -= army.getFoodRequire();
            }
        }
    }

    public void deploy(Board b){
        Army army;
        CommonTile t;
        boolean emptyTile = false;
        while(!emptyTile){
            try{
                t = this.chooseEmptyTile(b);
                emptyTile = true;
            }catch(TileNotEmptyException e){
            }
        }

        boolean setp = false;
        ArrayList<CommonTile> liste = b.getAdjacentCommonTile(t);
        while(!setp){
                 
            try{
                int number = (int) (Math.random()*4 +1);
                army = new Army(t, number, this);
            
                army.setPosition(t);
                t.setCharacter(army);
                setp = true;
            }catch(TileCapacityException e){
            }  
        }
        this.theCharacters.add(army);
        for(CommonTile c : liste){
            army.meet(c);
        }
    }


}
