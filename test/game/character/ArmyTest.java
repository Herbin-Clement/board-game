package game.character;

import static org.junit.Assert.*;
import org.junit.Test;

import game.exception.CapacityArmyException;
import game.player.WarPlayer;
import game.tile.*;



import org.junit.Before;

public class ArmyTest {
    private ForestTile forest;
    private MountainTile mountain;
    private DesertTile desert;
    private PlainTile plain;

    private Army armyforest;
    private Army armymountain;
    private Army armydesert;
    private Army armyplain;

    private WarPlayer player1;
    private WarPlayer player2;

    @Before
    public void init() throws CapacityArmyException{
        this.forest = new ForestTile(1, 1, 5, 1);
        this.mountain = new MountainTile(1, 2, 3, 0);
        this.desert = new DesertTile(2, 1, 5, 0);
        this.plain = new PlainTile(2, 2, 5, 5);

        this.armyforest = new Army(this.forest, 5, this.player1);
        this.armymountain = new Army(this.mountain, 2, this.player2);
        this.armydesert = new Army(this.desert, 1, this.player2);
        this.armyplain = new Army(this.plain, 5, this.player1);

        this.player1 = new WarPlayer("Clément");
        this.player2 = new WarPlayer("Alexis");
    }

    @Test(expected=CapacityArmyException.class) 
    public void testCreateArmyCapacityArmyException() throws CapacityArmyException{
        new Army(this.forest, 6, this.player1);
    }

    @Test
    public void testCreateArmyForAllTiles() throws CapacityArmyException{
        Army armyf = new Army(this.forest, 5, this.player1);
        Army armym = new Army(this.mountain, 2, this.player2);
        Army armyd = new Army(this.desert, 1, this.player2);
        Army armyp = new Army(this.plain, 5, this.player1);
        
        this.forest.setCharacter(armyf);
        this.mountain.setCharacter(armym);
        this.desert.setCharacter(armyd);
        this.plain.setCharacter(armyp);

        //getNumber
        assertEquals(armyf.getNumber(), 5);
        assertEquals(armym.getNumber(), 2);

        //getFoodRequire 
        assertEquals(armyf.getFoodRequire(), armyf.getNumber()); 
        assertEquals(armyd.getFoodRequire(), armyd.getNumber() * 2);
        assertEquals(armym.getFoodRequire(), armym.getNumber());
        assertEquals(armyp.getFoodRequire(), armyp.getNumber());

        //getPosition
        assertTrue(armyp.getPosition().equals(this.plain));
        
    }

    @Test 
    public void testAddAndRemove(){
        
        //add
        assertEquals(this.armydesert.getNumber(), 1);
        this.armydesert.addWarrior(2);
        assertEquals(this.armydesert.getNumber(), 3);

        //add dépassement du nombre
   
        this.armydesert.addWarrior(10);
        assertEquals(this.armydesert.getNumber(), this.armydesert.getPosition().getCapacity());
        this.armyplain.addWarrior(10);
        assertEquals(this.armyplain.getNumber(), this.armyplain.getPosition().getCapacity());
        

        //remove
        this.armyplain.removeWarrior();
        assertEquals(this.armyplain.getNumber(), 2); // 5/2 = 2
    }

    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.character.ArmyTest.class);
   } 
}
