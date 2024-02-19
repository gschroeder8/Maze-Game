package edu.wctc;

public class RoomThree extends Room {
    public RoomThree(String room) {
        super(room);
        setInteractable(true);
    }


    @Override
    public String getDescription() {
        return "The room seems to have a light fog blanketing the ground. You see something in the corner, it appears to be someone or something but you can't quite make it out.";
    }

}
