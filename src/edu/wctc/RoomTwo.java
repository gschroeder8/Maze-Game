package edu.wctc;

public class RoomTwo extends Room {
    public RoomTwo(String room) {
        super(room);
    }

    @Override
    public String getDescription() {
        return "This room seems to have a lot of exits. You can go in many directions. There is also a ladder leading up.";
    }


}
