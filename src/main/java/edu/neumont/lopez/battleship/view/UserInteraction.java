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
            int row = ConsoleUI.promptForInt("\nChoose a row", 1, 10);
            String col = ConsoleUI.promptForInput("\nChoose a column", false);

            int column = 0;
            if (col.equalsIgnoreCase("a")) {
                column = 0;
            } else if (col.equalsIgnoreCase("b")) {
                column = 1;
            } else if (col.equalsIgnoreCase("c")) {
                column = 2;
            } else if (col.equalsIgnoreCase("d")) {
                column = 3;
            } else if (col.equalsIgnoreCase("e")) {
                column = 4;
            } else if (col.equalsIgnoreCase("f")) {
                column = 5;
            } else if (col.equalsIgnoreCase("g")) {
                column = 6;
            } else if (col.equalsIgnoreCase("h")) {
                column = 7;
            } else if (col.equalsIgnoreCase("i")) {
                column = 8;
            } else if (col.equalsIgnoreCase("j")) {
                column = 9;
            }
            //TODO IF YOU PASS A NUMBER A COLUMN IT WILL STILL PASS
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
