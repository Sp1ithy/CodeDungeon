package com.company.classes.enemy;

import com.company.classes.Warrior;
import com.company.utils.DIRECTION;

public class Orc extends Enemy{
    private Warrior mobClass;
    public Orc(){
        mobClass = new Warrior();
    }

    @Override
    public void move(DIRECTION direction) {

    }
}
