package edu.wctc;

public class RoomOne extends Room {
    public RoomOne(String room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return "You are in the starting room. This room seems simple and without much to interact with.";
    }

}
