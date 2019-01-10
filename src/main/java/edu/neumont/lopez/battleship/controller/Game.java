package edu.neumont.lopez.battleship.controller;

import edu.neumont.lopez.battleship.model.Board;
import edu.neumont.lopez.battleship.model.Player;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Game {

    private final int BOARD_SIZE = 10;
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


//        board = new Board();
//        for (int i = 0; i < players.length; i++) {
//            String playerName = userInteraction.getPlayerName(i);
//            Player player = new Player(playerName, board);
//            players[i] = player;
//        }
//        this.turn = players[0];

//        board1.printBoard();
//
//        System.out.println(turn.getName());
//        System.out.println(turn.getBoard().toString());

    }

    private void switchTurn() {
        turn = (turn == player1 ? player2 : player1);
    }

    private void takeTurn() {

    }

    private void init() {
        iniPlayer(player1, "1");
        iniPlayer(player2, "2");

    }

    private void iniPlayer(Player player, String id) {
        player.setName(userInteraction.getPlayerName(id));
        Board board = new Board();
        board.init();
        board.placeShips();
    }
}
