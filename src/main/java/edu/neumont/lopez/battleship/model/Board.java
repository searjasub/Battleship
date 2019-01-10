package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Board {

    private final int BOARD_SIZE = 10;
    private final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private UserInteraction userInteraction = new UserInteraction();
    private Ship[] ships;
    private char[][] board;

    public Board() {
        this.board = new char[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '~';
            }
        }

        //placeShips();
    }


    private void initShips() {
        ships = new Ship[]{
                new Ship(Ships.CARRIER),
                new Ship(Ships.BATTLESHIP),
                new Ship(Ships.CRUISER),
                new Ship(Ships.SUBMARINE),
                new Ship(Ships.DESTROYER)};
    }

    public void placeShips() {
        Coordinate whereInBoard;

        System.out.println("Let's place your ships on the board.");
        for (Ship ship : ships) {
            System.out.println("Let's place the " + ship.getName() + "\nRemember that the size is " + ship.getSize());
            boolean horizontal = userInteraction.setShipOrientation();
            boolean isValid = false;
            while (!isValid) {
                whereInBoard = userInteraction.setStartingPoint();
                isValid = checkForAvailability(whereInBoard);
            }
        }
    }

    private boolean checkForAvailability(Coordinate coordinate) {

        if (coordinate.getCol() < 'A' || coordinate.getCol() > 'J') {
            System.out.println("Sorry that is not a valid column");
            return false;
        } else if (coordinate.getRow() < 0 || coordinate.getRow() > 10) {
            System.out.println("Sorry that is not a valid row");
            return false;
        }
        else {
            return true;
        }

    }

    public void printBoard(Player player) {
        System.out.println("\t");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("\t" + BOARD_LETTERS[i]);
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
