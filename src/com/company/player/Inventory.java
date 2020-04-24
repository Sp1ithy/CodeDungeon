package com.company.player;

import com.company.items.Item;

import java.util.List;

public class Inventory {
    private long capacity;
    private List<Item> items;
    public Inventory(){
        capacity = 10;
    }
    public Inventory(Player player){
        capacity = player.getStrength()*15;
    }

    public void addItem(Item item){

        items.add(item);
    }

    public void capacity(){

    }
}
