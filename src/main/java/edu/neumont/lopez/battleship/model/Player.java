package edu.neumont.lopez.battleship.model;

public class Player {

    private String name;
    private Board board;

    public Player(int id) {
    }

    public Player(String name, Board board) {
        this.setName(name);
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    public void placeShips(){
        board.placeShips();
    }
}
