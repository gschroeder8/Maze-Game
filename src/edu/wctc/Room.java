package edu.wctc;

public abstract class Room {
    private boolean isExitable;
    private boolean isInteractable;
    private boolean isLootable;
    private String name;
    private Room north, south, east, west, up, down;

    public Room(String name) {
        this.name = name;
    }

    public boolean isExitable() {
        return isExitable;
    }

    public void setExitable(boolean exitable) {
        isExitable = exitable;
    }

    public boolean isInteractable() {
        return isInteractable;
    }

    public void setInteractable(boolean interactable) {
        isInteractable = interactable;
    }

    public boolean isLootable() {
        return isLootable;
    }

    public void setLootable(boolean lootable) {
        isLootable = lootable;
    }

    public void setAbove(Room north) {
        this.north = north;
    }

    public void setBelow(Room south) {
        this.south = south;
    }

    public void setRight(Room east) {
        this.east = east;
    }

    public void setLeft(Room west) {
        this.west = west;
    }

    public void setUp(Room up) {
        this.up = up;
    }

    public void setDown(Room down) {
        this.down = down;
    }

    public String getDescription() {
        return "This is a " + name + " room.";
    }

    public Room getAdjoiningRoom(char direction) {
        switch (Character.toLowerCase(direction)) {
            case 'n':
                return north;
            case 's':
                return south;
            case 'e':
                return east;
            case 'w':
                return west;
            case 'u':
                return up;
            case 'd':
                return down;
            default:
                return null;
        }
    }

    public String getExits() {
        StringBuilder exits = new StringBuilder();
        if (north != null) exits.append("north ");
        if (south != null) exits.append("south ");
        if (east != null) exits.append("east ");
        if (west != null) exits.append("west ");
        if (up != null) exits.append("up ");
        if (down != null) exits.append("down ");

        return exits.toString();
    }

    public String getName() {
        return name;
    }

    public boolean isValidDirection(char direction) {
        switch (Character.toLowerCase(direction)) {
            case 'n':
                return north != null;
            case 's':
                return south != null;
            case 'e':
                return east != null;
            case 'w':
                return west != null;
            case 'u':
                return up != null;
            case 'd':
                return down != null;
            default:
                return false;
        }
    }


    @Override
    public String toString() {
        return "The room is " + name;
    }
}
