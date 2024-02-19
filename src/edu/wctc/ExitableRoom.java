package edu.wctc;

public class ExitableRoom extends Room {
    public ExitableRoom(String name) {
        super(name);
        setExitable(true);
    }

    @Override
    public String getDescription() {
        return "The Light!! You can see a doorway leading out of the maze! Do you exit or go back in to explore?";
    }

}
