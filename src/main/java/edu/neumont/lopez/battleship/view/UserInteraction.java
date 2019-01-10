package edu.neumont.lopez.battleship.view;

import edu.neumont.lopez.battleship.model.Coordinate;
import interfaces.ConsoleUI;

import java.io.IOException;

public class UserInteraction {

    public String getPlayerName(String id) {
        try {
            return ConsoleUI.promptForInput("Player " + id + ", what is your name?", false);
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
            return new Coordinate(row,col);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }
}
