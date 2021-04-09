package game.board;

import static org.junit.Assert.*;

import java.util.*;


import org.junit.Test;

import game.board.AgricolBoard;
import game.tile.*;



import org.junit.Before;

public class AgricolBoard {
    private int w;
    private int h;
    private WarBoard board;


    @Before
    public void init() {
        this.w = 18;
        this.h = 20;
        this.board = new AgricolBoard(this.w, this.h);
    }

    @Test
    public void allIsNotOccupated() {
        assertFalse(this.board.allIsOccupated());
    }

    @Test
    public void canGetWidth() {
        assertEquals(this.board.getWidth(), 20);
    }

    @Test
    public void canGetHeight() {
        assertEquals(this.board.getHeight(), 20);
    }

    @Test 
    public void noCommonTileAlone() {
        List<CommonTile> tiles;
        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                if (this.board.getTile(i, j) instanceof CommonTile) {
                    tiles = this.board.getAdjacentCommonTile((CommonTile) this.board.getTile(i, j));
                    assertTrue(tiles.size() > 0);
                }
            }
        }
    }

    @Test
    public void moreThanTwoThirdsOceanTile() {
        int nbTile = this.w * this.h;
        int nbCommonTile = 0;
        for (int i = 0; i < this.w; i++) {
            for (int j = 0; j < this.h; j++) {
                if (this.board.getTile(i, j) instanceof CommonTile) {
                    nbCommonTile++;
                }
            }
        }
        assertTrue(67 < 100 * (nbTile - nbCommonTile) / nbTile );
    }
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.board.AgricolBoard.class);
   } 
}
