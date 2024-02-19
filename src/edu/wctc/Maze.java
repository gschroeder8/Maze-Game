package edu.wctc;

import java.util.Scanner;

public class Maze {
    private Room currentRoom;
    private Player player;
    private boolean isFinished = false;

    public Maze() {
        player = new Player();

        Room RoomOne = new RoomOne("New Beginnings");
        Room RoomTwo = new RoomTwo("Library");
        Room RoomThree = new RoomThree("Thief's Den");
        Room InteractableRoom = new InteractableRoom("Library Attic");
        Room LootableRoom = new LootableRoom("Old Remains");
        Room exitableRoom = new ExitableRoom("Light at the End of the Tunnel");

        LootableRoom.setBelow(RoomOne);
        RoomOne.setAbove(LootableRoom);
        RoomOne.setBelow(RoomTwo);
        RoomTwo.setAbove(RoomOne);
        RoomTwo.setLeft(RoomThree);
        RoomThree.setRight(RoomTwo);
        RoomTwo.setUp(InteractableRoom);
        InteractableRoom.setDown(RoomTwo);
        RoomThree.setBelow(exitableRoom);
        exitableRoom.setAbove(RoomThree);

        currentRoom = RoomOne;
    }

    public String getCurrentRoomName() {
        return currentRoom.getName();
    }
    
    public String exitCurrentRoom() {
        if (currentRoom.isExitable()) {
            isFinished = true;
            return "You successfully exited the Maze congratulations!";
        } else {
            return "This room is not exitable.";
        }
    }

    public String interactWithCurrentRoom() {
        if (currentRoom.isInteractable()) {
            player.subtractFromScore(25);
            if (currentRoom instanceof InteractableRoom) {
                return "You interacted with a chest in the corner, it was full of small spiders that attacked you! You lost 25 points..";
            } else if (currentRoom instanceof RoomThree) {
                player.setScoreZero(0);
                player.removeFromInventory("Small bag of gold");
                player.addToInventory("Empty bag");
                //This is a very cruel mechanic but it brought me joy :)
                return "You interacted with a hunched over creature in the corner, IT WAS A THIEF! It took all of your coins and inventory and ran off with it!!!!.";
            } else {
                return "You interacted with a chest in the corner, nothing happened.";
            }
        } else {
            return "No interactions possible in this room.";
        }
    }

    //since I did not add more than one lootable room I did not implement the checking of which room is currently being looted
    //a good addition to this for scaling would be to add a check for which room is being looted so there can be different outcome
    //pending which room is currently being looted
    public String lootCurrentRoom() {
        if (currentRoom.isLootable()) {
            player.addToScore(100);
            player.addToInventory("Small bag of gold");
            return "You looted the pockets of the jacket and found a small bag of gold! It is worth 100 points..";
        } else {
            return "This room is not lootable.";
        }
    }

    public boolean move(char direction) {
        if (currentRoom.isValidDirection(direction)) {
            currentRoom = currentRoom.getAdjoiningRoom(direction);
            return true;
        } else {
            return false;
        }
    }

    public int getPlayerScore() {
        return player.getScore();
    }

    public String getPlayerInventory() {
        return "Inventory: " + player.getInventory();
    }

    public String getCurrentRoomDescription() {
        return currentRoom.getDescription();
    }

    public String getCurrentRoomExits() {
        return currentRoom.getExits();
    }

    public boolean isFinished() {
        return isFinished;
    }

    public boolean isinteractable() {
        return currentRoom.isInteractable();
    }

    public boolean isLootable() {
        return currentRoom.isLootable();
    }

    public boolean isExitable() {
        return currentRoom.isExitable();
    }

    public String getRoomStatus() {
        if (currentRoom.isInteractable()) {
            return "This room is interactable. (i)";
        } else if (currentRoom.isLootable()) {
            return "This room is lootable. (l)";
        } else if (currentRoom.isExitable()) {
            return "This room is exitable. (x)";
        } else {
            return "This room is not interactable, lootable, or exitable.";
        }
    }
}
