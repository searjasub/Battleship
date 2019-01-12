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
    private boolean horizontal;

    public void run() {
        System.out.println("Welcome to Battleship!");
        init();
        switchTurn();
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
        addExtraSpace();
        System.out.println("Ok " + turn.getName() + "Let's attack your opponent board\nHere is an empty board where we will be tracking the places you said.");
        turn.getAttackingBoard().printBoard();
        Coordinate coordinatesOfAttack;
        coordinatesOfAttack = userInteraction.getCoordinate();

        

    }












    private void placeShips() {
        Coordinate whereInBoard;
        System.out.println("Let's place your ships on the board.");
        turn.getBoard().printBoard();
        for (Ship ship : turn.getBoard().getShips()) {
            System.out.println("\nLet's place the " + ship.getName() + "\nRemember that the size is " + ship.getSize());
            horizontal = userInteraction.setShipOrientation();
            if (horizontal) {
                System.out.println("\n<--- Remember that the ship's direction is toward the right --->\n");
            } else {
                System.out.println("Remember that the ship's direction is toward down");
            }
            boolean isValid = false;
            while (!isValid) {
                boolean overlapping = true;
                while (overlapping) {
                    boolean direction = false;
                    while (!direction) {
                        whereInBoard = userInteraction.getCoordinate();
                        isValid = checkInsideBoard(ship, whereInBoard);
                        overlapping = checkForOverlapping(whereInBoard);
                        direction = updateBoardDirection(ship, whereInBoard);
                    }
                }
            }
            turn.getBoard().printBoard();
        }
        switchTurn();
    }

    //TODO WHEN PASSING 10 J AS A COORDINATE IT WILL PRINT TWICE THAT IS NOT A VALID COORDINATION (horizontal = N)
    private boolean updateBoardDirection(Ship s, Coordinate c) {
        if (horizontal) {
            int userEx = -1;
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = Ships.CARRIER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow(), c.getColumn() + i);
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = Ships.BATTLESHIP.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow(), c.getColumn() + i);
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = Ships.CRUISER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow(), c.getColumn() + i);
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = Ships.SUBMARINE.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow(), c.getColumn() + i);
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = Ships.DESTROYER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow(), c.getColumn() + i);
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + userEx][c.getColumn() + i].setState(State.UNHIT);
                }
            }
        } else {
            if (s.getSize() == Ships.CARRIER.getSize()) {
                for (int i = Ships.CARRIER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow() + i - 1, c.getColumn());
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + i - 1][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.BATTLESHIP.getSize()) {
                for (int i = Ships.BATTLESHIP.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow() + i - 1, c.getColumn());
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + i - 1][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.CRUISER.getSize()) {
                for (int i = Ships.CRUISER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow() + i - 1, c.getColumn());
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + i - 1][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.SUBMARINE.getSize()) {
                for (int i = Ships.SUBMARINE.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow() + 1 - 1, c.getColumn());
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + i - 1][c.getColumn()].setState(State.UNHIT);
                }
            } else if (s.getSize() == Ships.DESTROYER.getSize()) {
                for (int i = Ships.DESTROYER.getSize() - 1; i >= 0; i--) {
                    Coordinate newToCheck = new Coordinate(c.getRow() + i - 1, c.getColumn());
                    if (!checkInsideBoard(s, newToCheck)) {
                        return false;
                    }
                    turn.getBoard().getSquares()[c.getRow() + i - 1][c.getColumn()].setState(State.UNHIT);
                }
            }

        }

        return true;
    }

    //TODO CREATE A FOR LOOP TO START CHECKING EACH SPACE, STARTING FROM THE BACK
    private boolean checkForOverlapping(Coordinate coordinate) {
        if (turn.getBoard().getSquares()[coordinate.getRow() - 1][coordinate.getColumn()].getPrintValue() == State.EMPTY.getStatus()) {
            return false;
        }
        System.out.println("\nSorry but there is a ship already there, try a new coordinate.\n");
        return true;
    }

    private boolean checkInsideBoard(Ship s, Coordinate c) {

        if (horizontal) {
            if ((c.getColumn() <= 0 || c.getColumn() > 9)
                    && (turn.getBoard().getBOARD_SIZE() - c.getColumn() < s.getSize())) {
                System.out.println("\nSorry that is not a valid column, the ship will be sticking out.\nTry a new coordinate\n");
                return false;
            } else {
                return true;
            }
        } else {
            if ((c.getRow() <= 0 || c.getRow() >= 10)
                    && (turn.getBoard().getBOARD_SIZE() - c.getRow() < s.getSize())) {
                System.out.println("\nSorry that is not a valid row, the ship will be sticking out.\nTry a new coordinate\n");
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
        Board board = new Board();
        Board attackingBoard = new Board();
        player.setBoard(board);
        player.setAttackingBoard(attackingBoard);
        placeShips();
    }

    private void addExtraSpace() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
}
