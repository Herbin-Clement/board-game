package game.player;

import game.exception.CapacityArmyException;
import static org.junit.Assert.*;
import org.junit.Test;

import game.board.WarBoard;
import game.character.Army;
import game.tile.*;

import org.junit.Before;

public class WarPlayerTest{
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
    public void init() throws CapacityArmyException{
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

        this.forest.setCharacter(this.armyforest);
        this.mountain.setCharacter(this.armymountain);
        this.desert.setCharacter(this.armydesert);
        this.plain.setCharacter(this.armyplain);
    }

    @Test
    public void testCreationWarPlayer(){
        WarPlayer player = new WarPlayer("timoléon");

        //WarPlayer bien formé
        assertTrue(player.getName().equals("timoléon"));
        assertEquals(player.getFood(), 10);
        assertEquals(player.getNbCharacter(), 35);
        assertEquals(player.getGold(), 0);

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
        this.armydesert.addWarrior(2);//3
        this.armyforest.meet(this.desert);
        assertEquals(this.armydesert.getNumber(), 1);
        assertEquals(this.armyforest.getNumber(), 5);
    }

    @Test
    public void testAction() throws CapacityArmyException{
        this.playerG.recolt(); // +1 de recolte
        assertEquals(this.playerG.getFood(), 11);
        this.playerG.feed(); // 2 sand + 5 forest
        assertEquals(this.playerG.getFood(), 4);
        assertEquals(this.playerG.score(), 6); //6 + 0 gold

        //test bonus de 10 point
        ForestTile tilef1 = new ForestTile(5, 5, 5, 1);
        ForestTile tilef2 = new ForestTile(6, 5, 5, 1);
        Army armyf1 = new Army(tilef1, 1, this.playerB);
        Army armyf2 = new Army(tilef2, 2, this.playerB);
        tilef1.setCharacter(armyf1);
        tilef2.setCharacter(armyf2);
        this.playerB.theCharacters.add(armyf1);
        this.playerB.theCharacters.add(armyf2);


        DesertTile tiled1 = new DesertTile(6, 6, 5, 0);
        DesertTile tiled2 = new DesertTile(6, 7, 5, 0);
        Army armyd1 = new Army(tiled1, 1, this.playerB);
        Army armyd2 = new Army(tiled2, 2, this.playerB);
        tiled1.setCharacter(armyd1);
        tiled2.setCharacter(armyd2);
        this.playerB.theCharacters.add(armyd1);
        this.playerB.theCharacters.add(armyd2);

        PlainTile tilep1 = new PlainTile(7, 7, 5, 5);
        PlainTile tilep2 = new PlainTile(7, 8, 5, 5);
        Army armyp1 = new Army(tilep1, 1, this.playerB);
        Army armyp2 = new Army(tilep2, 2, this.playerB);
        tilep1.setCharacter(armyp1);
        tilep2.setCharacter(armyp2);
        this.playerB.theCharacters.add(armyp1);
        this.playerB.theCharacters.add(armyp2);

        MountainTile tilem1 = new MountainTile(8, 8, 3, 0);
        MountainTile tilem2 = new MountainTile(8, 9, 3, 0);
        Army armym1 = new Army(tilem1, 1, this.playerB);
        Army armym2 = new Army(tilem2, 2, this.playerB);
        tilem1.setCharacter(armym1);
        tilem2.setCharacter(armym2);
        this.playerB.theCharacters.add(armym1);
        this.playerB.theCharacters.add(armym2);

        assertEquals(this.playerB.score(), 32); // 5 + 8 desert + 4foret + 3plain + 12montagne 
    }

    
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.player.WarPlayerTest.class);
   }

}