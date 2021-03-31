package game;

import java.util.List;

import game.player.*;
import game.board.*;
public class AgricolGame extends Game{

    public AgricolGame(List<AgricolPlayer> ap, AgricolBoard b ){
        super(10);
        this.players = ap;
        this.board = b;
    }
}