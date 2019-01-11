package edu.neumont.lopez.battleship.controller;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.enumeration.State;
import edu.neumont.lopez.battleship.model.Board;
import edu.neumont.lopez.battleship.model.Coordinate;
import edu.neumont.lopez.battleship.model.Player;
import edu.neumont.lopez.battleship.model.Ship;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Game {

    private UserInteraction userInteraction = new UserInteraction();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player turn = player1;
    private Player notTurn = player2;
    private boolean gameOver = false;

    public void run() {

        System.out.println("Welcome to Battleship!");
        init();
        while (!gameOver) {
            takeTurn();
            switchTurn();
        }
    }

    private void switchTurn() {
        turn = (turn == player1 ? player2 : player1);
        notTurn = (notTurn == player2 ? player1 : player2);
    }

    private void takeTurn() {
        player1.getBoard().printBoard();
        player2.getBoard().printBoard();
        System.out.println(player1.getName());
        System.out.println(player2.getName());
        player1.getBoard().printSampleBoard();
        gameOver = true;

//        boolean isValid = false;
//
//
//        while (!isValid)
//            try {
//
//                turn.getBoard().attackBoard(notTurn);
//                isValid = true;
//            } catch (Exception ex) {
//                ex.getMessage();
//            }

    }

    public void placeShips() {
        Coordinate whereInBoard = null;
        System.out.println("Let's place your ships on the board.");
        turn.getBoard().printBoard();
        for (Ship ship : turn.getBoard().getShips()) {
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
                    whereInBoard = userInteraction.getCoordinate();
                    isValid = checkInsideBoard(horizontal, ship, whereInBoard);
                    overlapping = checkForOverlapping(whereInBoard);
                }
            }
            updateBoardDirection(horizontal, ship, whereInBoard);
            turn.getBoard().printBoard();
        }


    }

    private void updateBoardDirection(boolean b, Ship s, Coordinate c) {
        int userEx = -1;
        if (b) {
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = 0; i < Ships.CARRIER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = 0; i < Ships.BATTLESHIP.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = 0; i < Ships.CRUISER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = 0; i < Ships.SUBMARINE.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = 0; i < Ships.DESTROYER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            }
        } else {
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = userEx; i < Ships.CARRIER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = userEx; i < Ships.BATTLESHIP.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = userEx; i < Ships.CRUISER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = userEx; i < Ships.SUBMARINE.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = userEx; i < Ships.DESTROYER.getSize(); i++) {
                    turn.getBoard().getSquares()[c.getRow() + i][c.getColumn()].setState(State.UNHIT);
                }
            }

        }


    }

    private boolean checkForOverlapping(Coordinate coordinate) {
        if (turn.getBoard().getSquares()[coordinate.getRow() - 1][coordinate.getColumn()].getPrintValue() == State.EMPTY.getStatus()) {
            return false;
        }
        System.out.println("\nSorry but there is a ship already there, try a new coordinate.\n");
        return true;
    }

    private boolean checkInsideBoard(boolean b, Ship s, Coordinate c) {

        if (b) {
            if ((c.getColumn() <= 0 || c.getColumn() >= 10)
                    && (turn.getBoard().getBOARD_SIZE() - c.getColumn() < s.getSize())) {
                System.out.println("Sorry that is not a valid column, the ship will be sticking out.\nTry a new coordinate\n");
                return false;
            } else {
                return true;
            }
        } else {
            if ((c.getRow() <= 0 || c.getRow() >= 10)
                    && (turn.getBoard().getBOARD_SIZE() - c.getRow() < s.getSize())) {
                System.out.println("Sorry that is not a valid row, the ship will be sticking out.\nTry a new coordinate\n");
                return false;
            } else {
                return true;
            }
        }
    }


    private void init() {
        iniPlayer(player1, "1");
        iniPlayer(player2, "2");

    }

    private void iniPlayer(Player player, String id) {
        player.setName(userInteraction.getPlayerName(id));
        player.setBoard(new Board());
        player.getBoard().init();
        placeShips();
    }
}
