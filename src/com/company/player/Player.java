package com.company.player;

import com.company.classes.Entity;
import com.company.classes.Warrior;
import com.company.controller.CommandsListener;
import com.company.items.Item;
import com.company.locations.Dungeon;
import com.company.locations.Room;
import com.company.utils.DIRECTION;

import java.util.*;

public class Player extends Entity implements CommandsListener {

    private String playerName;
    private long playerId;
    private Entity playerClass;
    private Room location;
    private Scanner in;
    private Inventory playerInventory;

    public Player() {
        in = new Scanner(System.in);
        playerClass = new Warrior();
        playerInventory = new Inventory();
        location = new Dungeon();
    }

    public Player(long playerId, String playerName, Entity playerClass, Room location) {
        in = new Scanner(System.in);
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.location = location;
        playerInventory = new Inventory();
    }


    @Override
    public void userInput() {
        String input = in.next();
        //создать интерфейс маркер для всех метолов которые может вып пользователь
        Map<String,CommandsListener> commandList = new HashMap<>();
        if(commandList.containsKey(input)){
            commandList.get(input);
        }
    }

    public void playerDefeat(){

    }

    @Override
    public String myStats() {
        return playerName + "\n" + playerClass.toString();
    }

    @Override
    public void move(DIRECTION direction) {
        if(getAvailableDirections().contains(direction)){
            //переместиться
        }
        else{
            System.out.println("Sorry no such direction");
        }
    }

    public Room getLocation() {
        return location;
    }

    public long getPlayerId() {
        return playerId;
    }

    public void playerTurn() {
        userInput();
    }

    public boolean isAlive() {
        if (playerClass.getHp() > 0) return true;
        else return false;
    }

    public void playerRewards(List<Item> rewards){

    }

    @Override
    public List<DIRECTION> getAvailableDirections() {
        return location.getAvailableDirections();
    }
}
