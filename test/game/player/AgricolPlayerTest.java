package game.player;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

import game.player.AgricolPlayer;

public class AgricolPlayerTest{

    @Before
    public void init(){
        
    }
    
    public static junit.framework.Test suite() {
        return new junit.framework.JUnit4TestAdapter(game.player.Agricol.class);
   }

}