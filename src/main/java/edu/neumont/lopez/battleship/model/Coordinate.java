package edu.neumont.lopez.battleship.model;

public class Coordinate {

    private int row;
    private char col;

    public Coordinate(int row, char col) {
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public char getCol() {
        return col;
    }

    public void setCol(char col) {
        this.col = col;
    }

    public int getNumber() {
        if (getCol() == 'A') {
            return 1;
        } else if (getCol() == 'B') {
            return 1;
        } else if (getCol() == 'C') {
            return 1;
        } else if (getCol() == 'D') {
            return 1;
        } else if (getCol() == 'E') {
            return 1;
        } else if (getCol() == 'F') {
            return 1;
        } else if (getCol() == 'G') {
            return 1;
        } else if (getCol() == 'H') {
            return 1;
        } else if (getCol() == 'I') {
            return 1;
        } else {
            return 10;
        }
    }
}
