package com.company.classes.enemy;

import com.company.items.Item;

import java.util.LinkedList;
import java.util.List;


//Класс обертка, содержит список игроков, их дроп(выпадаемые предметы), так же методы для ENEMYTURN

public class EnemyLogic {
    private List<Enemy> enemyList;
    private List<Item> rewards;
    public EnemyLogic(){
        enemyList = new LinkedList<>();
        rewards = new LinkedList<>();
    }

    public EnemyLogic(Enemy...enemies){
        enemyList = new LinkedList<>();
        for(Enemy enemy : enemies){
            enemyList.add(enemy);
        }
    }

    public EnemyLogic(Enemy[] enemies, Item...rewards){
        enemyList = new LinkedList<>();
        for(Enemy enemy : enemies){
            enemyList.add(enemy);
        }
        for(Item item : rewards){
            this.rewards.add(item);
        }
    }

    public List<Enemy> getEnemyList() {
        return enemyList;
    }

    public void enemyTurn(){

    }

    public boolean isAlive(){
        for(Enemy enemy : enemyList){
            if(enemy.getHp()>0) return true;
        }
        return false;
    }

    public List<Item> getRewards() {
        return rewards;
    }
}
