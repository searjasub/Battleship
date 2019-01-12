package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;

public class Board {

    private final int BOARD_SIZE = 10;
    private final char[] BOARD_LETTERS = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
    private Ship[] ships;
    private Square[][] squares = new Square[BOARD_SIZE][BOARD_SIZE];

    public Board() {
        init();
    }

    private void init() {
        for (int row = 0; row < squares.length; row++) {
            for (int col = 0; col < squares[row].length; col++) {
                squares[row][col] = new Square();
            }
        }
        initShips();
    }

    public Ship[] getShips() {
        return ships;
    }


    public int getBOARD_SIZE() {
        return BOARD_SIZE;
    }

    private void initShips() {
        ships = new Ship[]{
                new Ship(Ships.CARRIER),
                new Ship(Ships.BATTLESHIP),
                new Ship(Ships.CRUISER),
                new Ship(Ships.SUBMARINE),
                new Ship(Ships.DESTROYER)};
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void printBoard() {

        System.out.println("\t");
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print("\t" + BOARD_LETTERS[i]);
        }
        System.out.println();
        for (int i = 0; i < BOARD_SIZE; i++) {
            System.out.print((i + 1) + "\t");
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(squares[i][j].getPrintValue() + "\t");
            }
            System.out.println();
        }
    }
}
