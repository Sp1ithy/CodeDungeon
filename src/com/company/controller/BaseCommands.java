package com.company.controller;

import com.company.utils.DIRECTION;

import java.util.List;

public interface BaseCommands {
     void chat(String message);
    String getStats();
    void move(DIRECTION direction);

    List<DIRECTION> getAvailableDirections();
    default void noSuchCommand(){
        System.out.println("No such command!");
    }
}
