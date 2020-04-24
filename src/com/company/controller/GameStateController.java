package com.company.controller;

import com.company.locations.Room;
import com.company.player.Player;
import com.company.utils.BATTLESTATE;
import com.company.utils.GAMESTATE;

public class GameStateController {

    private GAMESTATE currentState;
    private BATTLESTATE battlestate;
    private Player mainPlayer;

    public GameStateController() {
        mainPlayer = new Player();
        currentState = GAMESTATE.FREE;
        battlestate = BATTLESTATE.FREE;
    }

    public void stateSwitcher() {
        while (true) {
            switch (currentState) {
                case FREE:
                    mainPlayer.userInput();
                    break;
                case BATTLE:
                    battlestate = BATTLESTATE.START;
                    new BattleController(mainPlayer);
                    currentState = GAMESTATE.FREE;
                    break;
            }
        }
    }

}
