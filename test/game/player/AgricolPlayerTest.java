package game.player;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import game.tile.*;
import jdk.jfr.Timestamp;
import game.character.*;
import game.player.AgricolPlayer;


public class AgricolPlayerTest{

    private AgricolPlayer playerG;
    
    
    private ForestTile forest;
    private MountainTile mountain;
    private DesertTile desert;
    private PlainTile plain;

    private Worker workerforest;
    private Worker workermountain;
    private Worker workerdesert;
    private Worker workerplain;

    @Before
    public void init(){
        this.playerG = new AgricolPlayer("Good Guys");

        this.forest = new ForestTile(1, 1, 5, 2);
        this.mountain = new MountainTile(1, 2, 3, 8);
        this.desert = new DesertTile(2, 1, 5, 5);
        this.plain = new PlainTile(2, 2, 5, 2);

        this.workerforest = new Worker(this.forest, this.playerG);
        this.workermountain = new Worker(this.mountain, this.playerG);
        this.workerdesert = new Worker(this.desert, this.playerG);
        this.workerplain = new Worker(this.plain, this.playerG);

        this.playerG.theCharacters.add(this.workerforest);
        this.playerG.theCharacters.add(this.workerdesert);
        this.playerG.theCharacters.add(this.workermountain);
        this.playerG.theCharacters.add(this.workerplain);
    }

    @Test
    public void initTest(){
        assertTrue(this.playerG.getName() == "Good Guys");
        assertEquals(this.playerG.getRessource(), 0);
        assertEquals(this.playerG.theCharacters.size(), 4);
        assertEquals(playerG.getGold(), 15);
    }

    @Test
    public void FeedTestWhenHaveEnoughtGoldOrNot(){
        //feed workers when have enough gold
        this.playerG.feed();
        assertEquals(this.playerG.getGold(), 5);
        assertEquals(this.playerG.theCharacters.size(), 4);
        //feed workers when have no enough gold
        this.playerG.feed();
        assertEquals(this.playerG.getGold(), 0);
        assertEquals(this.playerG.theCharacters.size(), 3);
    }

    @Test
    public void recoltRessourceThenChangeIt(){
        //recolt the ressource
        this.playerG.recolt();
        assertEquals(this.playerG.getRessource(), 17);
        this.playerG.change();
        assertEquals(this.playerG.getRessource(), 0);
        assertEquals(this.playerG.getGold(), 32);
    }


    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.player.AgricolPlayerTest.class);
   }

}