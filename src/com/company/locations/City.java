package com.company.locations;

import com.company.utils.DIRECTION;

import java.util.List;

public class City extends Room {
    public City(){
        super();
    }
    public City(int roomId, List<DIRECTION> availableDirections,String roomDescription){
        super(roomId,availableDirections,roomDescription);
    }
}
