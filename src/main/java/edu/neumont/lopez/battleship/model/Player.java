package edu.neumont.lopez.battleship.model;

import java.util.ArrayList;

public class Player {

    private String name;
    private Board board;
    private ArrayList<Coordinate> coordinates = new ArrayList<>();


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

    public ArrayList<Coordinate> getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinate coordinates) {
        this.coordinates.add(coordinates);
    }

}
