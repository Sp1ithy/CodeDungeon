package com.company.player;

import com.company.classes.Entity;
import com.company.classes.Warrior;
import com.company.commands.Commands;
import com.company.controller.CommandsListener;
import com.company.items.Item;
import com.company.locations.Dungeon;
import com.company.locations.Room;
import com.company.utils.DIRECTION;

import java.util.List;
import java.util.Scanner;

public class Player extends Entity implements CommandsListener {

    private String playerName;
    private long playerId;
    private Entity playerClass; //рационально заменить на класс Stats, т.к это х-р игрока которые должны изменяться
    private Room location;
    private Scanner input;
    private Inventory playerInventory;
    private Commands commandExecutor;

    public Player() {
        input = new Scanner(System.in);
        playerClass = new Warrior();
        playerInventory = new Inventory();
        location = new Dungeon();
        commandExecutor = new Commands(this);
    }

    public Player(long playerId, String playerName, Entity playerClass, Room location) {
        input = new Scanner(System.in);
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerClass = playerClass;
        this.location = location;
        playerInventory = new Inventory();
    }

    //интерфейс ввода команд пользователем
    @Override
    public void userInput() {
        String buffer = input.nextLine();

        System.out.println("buffer = " + buffer);
        //если первый символ не '/' , то посылае сообщение в чат
        if (buffer.charAt(0) != '/') {
            chat(buffer);
        }
        //иначе разбиваем и отсылаем команду в обработчик
        else {
            String[] command = new String[3];
            command = buffer.split(" ");
            commandExecutor.executeCommand(command);
        }
    }

    public void playerDefeat() {

    }

    @Override
    public String getStats() {
        return playerName + "\n" + playerClass.toString();
    }

    @Override
    public void move(DIRECTION direction) {
        if (getAvailableDirections().contains(direction)) {
            //переместиться
        } else {
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
        return playerClass.getHp() > 0;
    }

    public void playerRewards(List<Item> rewards) {

    }

    @Override
    public List<DIRECTION> getAvailableDirections() {
        return location.getAvailableDirections();
    }
}
