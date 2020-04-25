package com.company.controller;

import com.company.utils.DIRECTION;

import java.util.List;
//интерфейс вводимых комманд
public interface CommandsListener extends BaseCommands  {

    void userInput();

    @Override
    default void chat(String message) {
        System.out.println("Your simple message : "+message);
    }





}
