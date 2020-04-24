package com.company.controller;

import com.company.utils.DIRECTION;

import java.util.List;
//интерфейс вводимых комманд
public interface CommandsListener extends BaseCommands  {

    void userInput();

    @Override
    default void chat() {

    }

    void move(DIRECTION direction);

   List<DIRECTION> getAvailableDirections();



}
