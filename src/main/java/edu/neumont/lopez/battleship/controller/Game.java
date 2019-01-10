package edu.neumont.lopez.battleship.controller;

import edu.neumont.lopez.battleship.model.Board;
import edu.neumont.lopez.battleship.model.Player;
import edu.neumont.lopez.battleship.view.UserInteraction;

public class Game {

    private UserInteraction userInteraction = new UserInteraction();
    private Board board;
    private Player[] players = new Player[2];
    private Player turn;
    private boolean gameOver = false;

    public void run() {

        System.out.println("Welcome to Battleship!");
        init();
//        while (!gameOver){
//            takeTurn();
//        }

        board = new Board();
        for (int i = 0; i < players.length; i++) {
            String playerName = userInteraction.getPlayerName(i);
            Player player = new Player(playerName, board);
            players[i] = player;
        }
        this.turn = players[1];

        board.printBoard(turn);

    }

    private void takeTurn() {

    }

    private void init() {

    }
}
