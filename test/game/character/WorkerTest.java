package game.character;


import static org.junit.Assert.*;
import org.junit.Test;

import game.player.AgricolPlayer;
import game.tile.*;

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

        this.workerforest = new Worker(this.forest, 5, this.player1);
        this.workermountain = new Worker(this.mountain, 2, this.player2);
        this.workerdesert = new Worker(this.desert, 1, this.player2);
        this.workerplain = new Worker(this.plain, 5, this.player1);

       
    }
    

    @Test 
    public void correctGoldRequireTest(){
        assertEquals(this.workerforest, 2);
        assertEquals(this.workermountain, 8);
        assertEquals(this.workerdesert, 5);
        assertEquals(this.workerplain, 2);
    }

    @Test
    public void earnGoldTest(){
        //initial quantity of gold
        assertEquals(this.workerforest,0);       
        assertEquals(this.workermountain, 0);
        assertEquals(this.workerdesert,0);
        assertEquals(this.workerplain,0);
        // add gold
        this.workerforest.earnGold();   
        this.workermountain.earnGold();
        this.workerdesert.earnGold();
        this.workerplain.earnGold();
        // check if the gold is added 
        assertEquals(this.workerforest.getGold(), 2);
        assertEquals(this.workermountain..getGold(), 8);
        assertEquals(this.workerdesert.getGold(), 5);
        assertEquals(this.workerplain.getGold(), 2);
    }



    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.character.WorkerTest.class);
   }
}
