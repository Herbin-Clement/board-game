package game;

import java.util.ArrayList;
import java.util.List;

import game.board.*;
import game.player.*;
public class WarGame extends Game{

    public WarGame(List<WarPlayer> wp, WarBoard b){
        super(10);
        this.players = wp;
        this.board = b;

    }
}
