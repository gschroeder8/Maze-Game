package edu.wctc;

public class InteractableRoom extends Room {
    public InteractableRoom(String name) {
        super(name);
        setInteractable(true);
    }

    @Override
    public String getDescription() {
        return "This room feels cramped and has cobwebs all over. There is a few chests laying around that mostly seem to be locked up but one is cracked open.";
    }

}
