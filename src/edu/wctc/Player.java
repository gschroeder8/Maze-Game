package edu.wctc;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int score;
    private List<String> inventory = new ArrayList<>();

    public Player() {
        score = 0;
    }

    public void addToInventory(String item) {
        inventory.add(item);
    }

    public void removeFromInventory(String item) {
        inventory.remove(item);
    }

    public void addToScore(int points) {
        score += points;
    }

    public void subtractFromScore(int points) {
        score -= points;
    }

    public void setScoreZero(int points) {
        score = 0;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "Inventory is empty";
        } else {
            return ("Inventory: " + inventory);
        }
    }

    public int getScore() {
        return score;
    }
}
