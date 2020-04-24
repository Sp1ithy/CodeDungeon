package com.company.controller;

import com.company.classes.enemy.Enemy;
import com.company.classes.enemy.EnemyLogic;
import com.company.locations.Dungeon;
import com.company.player.Player;
import com.company.utils.BATTLESTATE;

import java.util.*;

//Класс-контроллер боя
public class BattleController {

    private BATTLESTATE battlestate;
    private Player mainPlayer;
    private EnemyLogic enemies;     //тут внимательно, это класс обертка над обычными врагами


    public BattleController(Player mainPlayer) {
        this.mainPlayer = mainPlayer;
        this.enemies = ((Dungeon) mainPlayer.getLocation()).getEnemies();
        battleMode();
    }


    public void battleMode() {
        boolean exitFlag = false;
        if (mainPlayer.getLocation() instanceof Dungeon) {
            enemies = ((Dungeon) mainPlayer.getLocation()).getEnemies();
        } else return;
        battlestate = calculateInitiative(mainPlayer, enemies);
        while (!exitFlag) {
            switch (battlestate) {
                case PLAYERTURN:
                    mainPlayer.playerTurn();
                    if (mainPlayer.isAlive()) battlestate = BATTLESTATE.ENEMYTURN;
                    else battlestate = BATTLESTATE.LOSE;
                    break;
                case ENEMYTURN:
                    enemies.enemyTurn();
                    if (enemies.isAlive()) battlestate = BATTLESTATE.PLAYERTURN;
                    else battlestate = BATTLESTATE.WIN;
                case LOSE:
                    mainPlayer.playerDefeat();
                    exitFlag = true;
                    break;
                case WIN:
                    mainPlayer.playerRewards(enemies.getRewards());
                    exitFlag = true;
                    break;
            }
        }
        battlestate = BATTLESTATE.FREE;
        return;
    }

    //метод вычисления инициативы, чтобы понять кто ходит первый
    private BATTLESTATE calculateInitiative(Player player, EnemyLogic enemies) {
        Map<Long, Integer> initiative = new HashMap<>();
        initiative.put(player.getPlayerId(), player.getIntelligence());
        List<Enemy> enemyList = enemies.getEnemyList();
        for (Enemy enemy : enemyList) {
            initiative.put(enemy.getEnemyId(), enemy.getIntelligence());
        }
        long firstTurn = Collections.max(initiative.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getKey();
        if (firstTurn == player.getPlayerId()) {
            return BATTLESTATE.PLAYERTURN;
        } else return BATTLESTATE.ENEMYTURN;
    }
}
