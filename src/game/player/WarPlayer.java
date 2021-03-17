package game.player;

import java.util.ArrayList;

import game.board.Board;
import game.character.Army;
import game.exception.DeployException;
import game.tile.*;

public class WarPlayer extends Player{
    protected int food;

    public WarPlayer(String n){
        super(n, 0, 35);
        this.food = 10;
        this.theCharacters = new ArrayList<Army>();
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

    public void deploy(Board b)throws DeployException{
        CommonTile t = this.chooseTile(b);
        
        if(t.isEmpty()){
            ArrayList<CommonTile> liste = b.getAdjacentCommonTile(t); //pas de Ocean Tile
            int number = (int) (Math.random()*4 +1);
            Army army = new Army(t, number, this);
            t.setCharacter(army);
            army.setPosition(t);
            this.theCharacters.add(army);
            for(CommonTile c : liste){
                army.meet(c);
            }
        }
        else{
            throw new DeployException("the case is Occupated");
        }
    }

    
}
