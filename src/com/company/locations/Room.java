package com.company.locations;

import com.company.utils.DIRECTION;

import java.util.LinkedList;
import java.util.List;

public class Room {
    private int roomId;
    private List<DIRECTION> availableDirections;
    private String roomDescription;

    public Room(){
        roomId = 0;
        availableDirections = new LinkedList<>();
        roomDescription = "Start city";
    }
    public Room(int roomId, List<DIRECTION> availableDirections,String roomDescription) {
        this.roomId = roomId;
        this.availableDirections = availableDirections;

    }

    public int getRoomId() {
        return roomId;
    }

    public List<DIRECTION> getAvailableDirections() {
        return availableDirections;
    }

    public String getRoomDescription() {
        return roomDescription;
    }
}
