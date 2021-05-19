package game.tile;

import static org.junit.Assert.*;

import java.util.*;


import org.junit.Test;

import game.tile.*;
import game.character.*;
import game.character.Character;
import game.exception.CapacityArmyException;
import game.player.*;



import org.junit.Before;


/**
 * @author Grassien Léa, Herbin Clément, Codevelle Alexis
 * 
 */

public class CommonTileTest {
    private Player p;
    private PlainTile plainTile;
    private ForestTile forestTile;
    private MountainTile mountainTile;
    private DesertTile desertTile;
    private Character c5;
    private Character c3;

    @Before
    public void init() throws CapacityArmyException{
        this.p = new WarPlayer("Leaxis");
        this.plainTile = new PlainTile(0, 0, 5, 5);
        this.forestTile = new ForestTile(0, 0, 5, 1);
        this.mountainTile = new MountainTile(0, 0, 3, 0);
        this.desertTile = new DesertTile(0, 0, 3, 0);
        this.c5 = new Army(plainTile, 5, p);
        this.c3 = new Army(plainTile, 3, p);
    }

    @Test
    public void canSetAndGetCharachter() {
        this.plainTile.setCharacter(this.c5);
        assertEquals(this.plainTile.getCharacter(), this.c5);
    }

    @Test 
    public void canBeEmpty() {
        assertTrue(this.plainTile.isEmpty());
    }

    @Test
    public void canGetCapacityPlainAndForest() {
        assertEquals(this.plainTile.getCapacity(), 5);
        assertEquals(this.forestTile.getCapacity(), 5);
    }

    @Test
    public void canGetCapacityDesertAndMoutain() {
        assertEquals(this.desertTile.getCapacity(), 3);
        assertEquals(this.mountainTile.getCapacity(), 3);
    }

    @Test 
    public void canGetRessourceValuePlain() {
        assertEquals(this.plainTile.getRessourceValue(), 5);
    }

    @Test 
    public void canGetRessourceValueForest() {
        assertEquals(this.forestTile.getRessourceValue(), 1);
    }

    @Test 
    public void canGetRessourceValueMoutain() {
        assertEquals(this.mountainTile.getRessourceValue(), 0);
    }

    @Test 
    public void canGetRessourceValueDesert() {
        assertEquals(this.desertTile.getRessourceValue(), 0);
    }

    @Test 
    public void foodRequireIs0WhenNoOneOnTile() {
        System.out.println(this.plainTile.getFoodRequire());
        assertEquals(this.plainTile.getFoodRequire(), 0);
    }
    
    @Test 
    public void getFoodRequirePlainTile() {
        this.plainTile.setCharacter(c5);
        assertEquals(this.plainTile.getFoodRequire(), 5);
    }
    
    @Test 
    public void getFoodRequireForestTile() {
        this.forestTile.setCharacter(c5);
        assertEquals(this.forestTile.getFoodRequire(), 5);
    }

    @Test 
    public void getFoodRequireMountainTile() {
        this.mountainTile.setCharacter(c3);
        assertEquals(this.mountainTile.getFoodRequire(), 3);
    }

    @Test 
    public void getFoodRequireDesertTile() {
        this.desertTile.setCharacter(c3);
        assertEquals(this.desertTile.getFoodRequire(), 6);
    }

    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.tile.CommonTileTest.class);
   } 
}
