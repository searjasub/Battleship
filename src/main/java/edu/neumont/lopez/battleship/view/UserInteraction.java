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

    public Coordinate setStartingPoint() {
        try {
            int row = ConsoleUI.promptForInt("Choose a row", 1, 10);
            char col = ConsoleUI.promptForChar("Choose a column (letter must be capitilzed)", 'A', 'J');

            int column;
            if (col == 'A') {
                column = 0;
            } else if (col == 'B') {
                column = 1;
            } else if (col == 'C') {
                column = 2;
            } else if (col == 'D') {
                column = 3;
            } else if (col == 'E') {
                column = 4;
            } else if (col == 'F') {
                column = 5;
            } else if (col == 'G') {
                column = 6;
            } else if (col == 'H') {
                column = 7;
            } else if (col == 'I') {
                column = 8;
            } else {
                column = 9;
            }
            return new Coordinate(row, column);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
