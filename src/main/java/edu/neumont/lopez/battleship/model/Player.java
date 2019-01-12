package edu.neumont.lopez.battleship.model;

public class Player {

    private String name;
    private Board board;
    private Board attackingBoard;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public Board getAttackingBoard() {
        return attackingBoard;
    }

    public void setAttackingBoard(Board attackingBoard) {
        this.attackingBoard = attackingBoard;
    }
}
