package edu.wctc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Maze maze = new Maze();
        Scanner scanner = new Scanner(System.in);

        System.out.println("--------------------");
        System.out.println("Controls: ");
        System.out.println("n: move north");
        System.out.println("s: move south");
        System.out.println("e: move east");
        System.out.println("w: move west");
        System.out.println("u: move above");
        System.out.println("d: move below");
        System.out.println("i: interact with room");
        System.out.println("l: loot room");
        System.out.println("x: exit room");
        System.out.println("v: view inventory");
        System.out.println("--------------------");

        System.out.println("Your goal is to get to the exit with as many points as possible!\nHave Fun!!!!!\n");

        while (!maze.isFinished()) {
            System.out.println("Current room: " + maze.getCurrentRoomName());
            System.out.println("Description: " + maze.getCurrentRoomDescription());
            System.out.println("Options: " + maze.getRoomStatus());
            System.out.println("Exits: " + maze.getCurrentRoomExits());
            System.out.print("Enter a command: ");
            char command = scanner.next().charAt(0);
            System.out.println();

            switch (command) {
                case 'n':
                case 's':
                case 'e':
                case 'w':
                case 'u':
                case 'd':
                    if (!maze.move(command)) {
                        System.out.println("Cannot move in that direction.");
                    }
                    break;
                case 'i':
                    System.out.println(maze.interactWithCurrentRoom());
                    break;
                case 'l':
                    System.out.println(maze.lootCurrentRoom());
                    break;
                case 'x':
                    System.out.println(maze.exitCurrentRoom());
                    break;
                case 'v':
                    System.out.println("Inventory: " + maze.getPlayerInventory());
                    break;
                default:
                    System.out.println("Invalid command.");
            }
        }

        // Maze finished, display final score
        System.out.println("Your final score: " + maze.getPlayerScore());

        if (maze.getPlayerScore() <= 0) {
            System.out.println("You lost all your points, better luck next time!");
        } else if (maze.getPlayerScore() > 0 && maze.getPlayerScore() < 100) {
            System.out.println("You did not get all of the points, better luck next time!");
        } else {
            System.out.println("Congratulations, you won!");
        }

        scanner.close();
    }
}
