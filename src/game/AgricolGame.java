package game;

import java.util.List;

import game.player.*;
public class AgricolGame extends Game{

    public AgricolGame(List<AgricolPlayer> ap){
        super(10);
        this.players = ap;
    }
}