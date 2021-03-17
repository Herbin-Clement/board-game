package game;

import java.util.List;

import game.player.*;
public class WarGame extends Game{

    public WarGame(List<WarPlayer> wp){
        super(10);
        this.players = wp;
        

    }
}
