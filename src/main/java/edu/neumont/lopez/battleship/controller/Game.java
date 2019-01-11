package edu.neumont.lopez.battleship.controller;

import edu.neumont.lopez.battleship.model.Board;
import edu.neumont.lopez.battleship.model.Player;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Game {

    private UserInteraction userInteraction = new UserInteraction();
    private Player player1 = new Player();
    private Player player2 = new Player();
    private Player turn = player1;
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
    }

    private void takeTurn() {
        player1.getBoard().printBoard();
        player2.getBoard().printBoard();
        System.out.println(player1.getName());
        System.out.println(player2.getName());
        player1.getBoard().printSampleBoard();
        gameOver = true;

    }

    private void init() {
        iniPlayer(player1, "1");
        iniPlayer(player2, "2");

    }

    private void iniPlayer(Player player, String id) {
        player.setName(userInteraction.getPlayerName(id));
        player.setBoard(new Board());
        player.getBoard().init();
        player.getBoard().placeShips();
    }
}
