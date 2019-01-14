package edu.neumont.lopez.battleship.view;

import edu.neumont.lopez.battleship.model.Coordinate;
import interfaces.ConsoleUI;

import java.io.IOException;

public class UserInteraction {

    public String getPlayerName(String id) {
        try {
            return ConsoleUI.promptForInput("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                    "\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n" +
                    "Player " + id + ", what is your name?", false);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean setShipOrientation() {
        try {
            return ConsoleUI.promptForBool("\nDo you want to place the ship horizontally?", "Y", "N");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public Coordinate getCoordinate() {
        try {
            boolean isValid = false;
            int row = 0;
            String col;
            int column = 0;
            while (!isValid) {

                row = ConsoleUI.promptForInt("\nChoose a row", 1, 10);
                col = ConsoleUI.promptForInput("\nChoose a column", false);

                if (col.equalsIgnoreCase("a")) {
                    isValid = true;
                } else if (col.equalsIgnoreCase("b")) {
                    column = 1;
                    isValid = true;
                } else if (col.equalsIgnoreCase("c")) {
                    column = 2;
                    isValid = true;
                } else if (col.equalsIgnoreCase("d")) {
                    column = 3;
                    isValid = true;
                } else if (col.equalsIgnoreCase("e")) {
                    column = 4;
                    isValid = true;
                } else if (col.equalsIgnoreCase("f")) {
                    column = 5;
                    isValid = true;
                } else if (col.equalsIgnoreCase("g")) {
                    column = 6;
                    isValid = true;
                } else if (col.equalsIgnoreCase("h")) {
                    column = 7;
                    isValid = true;
                } else if (col.equalsIgnoreCase("i")) {
                    column = 8;
                    isValid = true;
                } else if (col.equalsIgnoreCase("j")) {
                    column = 9;
                    isValid = true;
                } else {
                    System.out.println("Sorry that's not a valid column, please try again");
                }
            }
            return new Coordinate(row, column);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

    public boolean done() {
        try {
            return ConsoleUI.promptForBool("Are you ready to pass the laptop?", "Y", "N");
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
