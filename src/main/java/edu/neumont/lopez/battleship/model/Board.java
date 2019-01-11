package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.enumeration.State;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Board {

    private final int BOARD_SIZE = 10;
    private final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private UserInteraction userInteraction = new UserInteraction();
    private Ship[] ships;
    private Square[][] board = new Square[BOARD_SIZE][BOARD_SIZE];

    public Board() {
    }

    public void init() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = new Square();
            }
        }
        initShips();
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
        Coordinate whereInBoard = null;
        System.out.println("Let's place your ships on the board.");
        printBoard();
        for (Ship ship : ships) {
            System.out.println("\nLet's place the " + ship.getName() + "\nRemember that the size is " + ship.getSize());
            boolean horizontal = userInteraction.setShipOrientation();
            if (horizontal) {
                System.out.println("\n<--- Remember that the ship's direction is toward the right --->\n");
            } else {
                System.out.println("Remember that the ship's direction is toward down");
            }
            boolean isValid = false;
            while (!isValid) {
                boolean overlapping = true;
                while (overlapping) {
                    whereInBoard = userInteraction.setStartingPoint();
                    isValid = checkInsideBoard(horizontal, ship, whereInBoard);
                    overlapping = checkForOverlapping(whereInBoard);
                }
            }
            updateBoardDirection(horizontal, ship, whereInBoard);
            printBoard();
        }
    }

    private void updateBoardDirection(boolean b, Ship s, Coordinate c) {
        int userEx = -1;
        if (b) {
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = 0; i < Ships.CARRIER.getSize(); i++) {
                    board[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = 0; i < Ships.BATTLESHIP.getSize(); i++) {
                    board[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = 0; i < Ships.CRUISER.getSize(); i++) {
                    board[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = 0; i < Ships.SUBMARINE.getSize(); i++) {
                    board[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = 0; i < Ships.DESTROYER.getSize(); i++) {
                    board[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            }
        } else {
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = userEx; i < Ships.CARRIER.getSize(); i++) {
                    board[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = userEx; i < Ships.BATTLESHIP.getSize(); i++) {
                    board[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = userEx; i < Ships.CRUISER.getSize(); i++) {
                    board[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = userEx; i < Ships.SUBMARINE.getSize(); i++) {
                    board[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = userEx; i < Ships.DESTROYER.getSize(); i++) {
                    board[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            }

        }


    }

    private boolean checkForOverlapping(Coordinate coordinate) {
        if (board[coordinate.getRow() - 1][coordinate.getColumn()].getPrintValue() == State.EMPTY.getStatus()) {
            return false;
        }
        System.out.println("\nSorry but there is a ship already there, try a new coordinate.\n");
        return true;
    }

    private boolean checkInsideBoard(boolean b, Ship s, Coordinate c) {

        if (b) {
            if ((c.getColumn() <= 0 || c.getColumn() >= 10)
                    && (BOARD_SIZE - c.getColumn() < s.getSize())) {
                System.out.println("Sorry that is not a valid column, the ship will be sticking out.\nTry a new coordinate\n");
                return false;
            } else {
                return true;
            }
        } else {
            if ((c.getRow() <= 0 || c.getRow() >= 10)
                    && (BOARD_SIZE - c.getRow() < s.getSize())) {
                System.out.println("Sorry that is not a valid row, the ship will be sticking out.\nTry a new coordinate\n");
                return false;
            } else {
                return true;
            }
        }
    }


//    public State fire(char row, char col, Player player){
//
//        player
//    }

    public void printBoard() {

        System.out.println("\t");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("\t" + BOARD_LETTERS[i]);
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j].getPrintValue() + "\t");
            }
            System.out.println();
        }
    }

    public void printSampleBoard(){
        System.out.println("\t");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("\t" + BOARD_LETTERS[i]);
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print('~' + "\t");
            }
            System.out.println();
        }
    }
}
