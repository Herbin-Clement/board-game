package game.player;

import static org.junit.Assert.*;
import org.junit.Test;

import game.board.WarBoard;

import org.junit.Before;

public class AgricolPlayerTest{
    private WarPlayer playerG;
    private WarPlayer playerB;
    
    private ForestTile forest;
    private MountainTile mountain;
    private DesertTile desert;
    private PlainTile plain;

    private Army armyforest;
    private Army armymountain;
    private Army armydesert;
    private Army armyplain;

    @Before
    public void init(){
        this.playerG = new WarPlayer("Good Guys");
        this.playerB = new WarPlayer("Bad Guys");

        this.forest = new ForestTile(1, 1, 5, 1);
        this.mountain = new MountainTile(1, 2, 3, 0);
        this.desert = new DesertTile(2, 1, 5, 0);
        this.plain = new PlainTile(2, 2, 5, 5);

        this.armyforest = new Army(this.forest, 5, this.playerG);
        this.armymountain = new Army(this.mountain, 2, this.playerB);
        this.armydesert = new Army(this.desert, 1, this.playerG);
        this.armyplain = new Army(this.plain, 5, this.playerB);

        this.playerG.theCharacters.add(this.armyforest);
        this.playerG.theCharacters.add(this.armydesert);
        this.playerB.theCharacters.add(this.armymountain);
        this.playerB.theCharacters.add(this.armyplain);
    }

    @Test
    public void testCreationWarPlayer(){
        WarPlayer player = new WarPlayer("timoléon");

        //WarPlayer bien formé
        assertTrue(player.getName().equals("timoléon"));
        assertEquals(player.getFood(), 10);
        assertEquals(player.getNbCharacter(), 35);
        assertFalse(player.getGold());

    }

    @Test 
    public void testMeetOther(){
        

        //rencontre autre armée ennemis plus petite
        assertEquals(this.armymountain.getGold(), 0);
        assertTrue(this.armydesert.getOwner().equals(this.playerG));
        this.armymountain.meet(this.desert);
        assertTrue(this.armydesert.getOwner().equals(this.playerB));
        assertEquals(this.armymountain.getGold(), 2);

        //rencontre allié plus nombreux
        assertEquals(this.armydesert.getGold(), 0);
        this.armydesert.meet(this.mountain);
        assertEquals(this.armydesert.getGold(), 1);
        assertEquals(this.armymountain.getNumber(), 3);

        //rencontre ennemis inférieur
        this.armydesert.add(2);
        this.armyforest.meet(this.desert);
        assertEquals(this.armydesert.getNumber(), 2);
        assertEquals(this.armyforest.getNumber(), 2);

    }

    @Test
    public void test 
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.player.WarPlayerTest.class);
   }

}