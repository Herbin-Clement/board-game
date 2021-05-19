package game.character;


import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import game.player.AgricolPlayer;
import game.tile.*;


/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class WorkerTest {

    private ForestTile forest;
    private MountainTile mountain;
    private DesertTile desert;
    private PlainTile plain; 

    private Worker workerforest;
    private Worker workermountain;
    private Worker workerdesert;
    private Worker workerplain;

    private AgricolPlayer player1;
    private AgricolPlayer player2;
    
    @Before
    public void init(){
        this.forest = new ForestTile(1, 1, 1, 2);
        this.mountain = new MountainTile(1, 2, 1, 8);
        this.desert = new DesertTile(2, 1, 1, 5);
        this.plain = new PlainTile(2, 2, 1, 2);

        this.player1 = new AgricolPlayer("Clément");
        this.player2 = new AgricolPlayer("Léa");

        this.workerforest = new Worker(this.forest, this.player1);
        this.workermountain = new Worker(this.mountain, this.player2);
        this.workerdesert = new Worker(this.desert, this.player2);
        this.workerplain = new Worker(this.plain, this.player1);

       
    }
    

    @Test 
    public void correctGoldRequireTest(){
        assertEquals(this.workerforest.getGoldRequire(), 1);
        assertEquals(this.workermountain.getGoldRequire(), 5);
        assertEquals(this.workerdesert.getGoldRequire(), 3);
        assertEquals(this.workerplain.getGoldRequire(), 1);
    }

    @Test
    public void earnGoldTest(){
        //initial quantity of gold
        assertEquals(this.workerforest.getGold(),0);       
        assertEquals(this.workermountain.getGold(), 0);
        assertEquals(this.workerdesert.getGold(),0);
        assertEquals(this.workerplain.getGold(),0);
        // add gold
        this.workerforest.earnGold(0);   
        this.workermountain.earnGold(0);
        this.workerdesert.earnGold(0);
        this.workerplain.earnGold(0);
        // check if the gold is added 
        assertEquals(this.workerforest.getGold(), 1);
        assertEquals(this.workermountain.getGold(), 5);
        assertEquals(this.workerdesert.getGold(), 3);
        assertEquals(this.workerplain.getGold(), 1);
    }



    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.character.WorkerTest.class);
   }
}
