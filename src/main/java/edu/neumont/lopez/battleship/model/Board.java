package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Board {

    private final int BOARD_SIZE = 10;
    private final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private UserInteraction userInteraction = new UserInteraction();
    private Ship[] ships;
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];

    public Board() {
//        this.board = new char[BOARD_SIZE][BOARD_SIZE];
//        for (int i = 0; i < BOARD_SIZE; i++) {
//            for (int j = 0; j < BOARD_SIZE; j++) {
//                board[i][j] = '~';
//            }
//        }
//
//        //placeShips();
    }

    public void init() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                board[row][col] = '~';
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
        Coordinate whereInBoard;

        System.out.println("Let's place your ships on the board.");
        printBoard();
        for (Ship ship : ships) {
            System.out.println("\nLet's place the " + ship.getName() + "\nRemember that the size is " + ship.getSize());
            boolean horizontal = userInteraction.setShipOrientation();
            boolean isValid = false;
            while (!isValid) {
                whereInBoard = userInteraction.setStartingPoint();
                isValid = checkForAvailability(whereInBoard, horizontal, ship);
            }
            updateBoard();
        }
    }

    //TODO the board is not updating after placing the ship
    private void updateBoard() {

    }

    public boolean checkForAvailability(Coordinate coordinate, boolean horizontal, Ship ship) {

        if (horizontal) {
            if ((coordinate.getCol() <= 'A' || coordinate.getCol() >= 'J')
                    && (BOARD_SIZE - coordinate.getNumber() < ship.getSize())) {
                System.out.println("Sorry that is not a valid column, the ship will be sticking out.\nTry a new coordinate");
                return false;
            } else {
                return true;
            }
        } else {
            if ((coordinate.getRow() <= 0 || coordinate.getRow() >= 10)
                    && (BOARD_SIZE - coordinate.getRow() < ship.getSize())) {
                System.out.println("Sorry that is not a valid row, the ship will be sticking out.\nTry a new coordinate");
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
                System.out.print(board[i][j] + "\t");
            }
            System.out.println();
        }
    }

//    @Override
//    public String toString(){
//        printBoard();
//        return "\n";
//    }

//    public Board initBoard(int board_size) {
//        Board board =
//    }
}
