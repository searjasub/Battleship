package edu.neumont.lopez.battleship.model;

public class Coordinate {

    private int row;
    private char col;
    private int column;

    public Coordinate(int row, char col) {
        this.setRow(row);
        this.setCol(col);
    }

    public Coordinate(int row, int column) {
        this.setRow(row);
        this.setColumn(column);
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

    public void setCol(int col) {
        this.column = col;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getNumber() {
        if (getCol() == 'A') {
            return 0;
        } else if (getCol() == 'B') {
            return 1;
        } else if (getCol() == 'C') {
            return 2;
        } else if (getCol() == 'D') {
            return 3;
        } else if (getCol() == 'E') {
            return 4;
        } else if (getCol() == 'F') {
            return 5;
        } else if (getCol() == 'G') {
            return 6;
        } else if (getCol() == 'H') {
            return 7;
        } else if (getCol() == 'I') {
            return 8;
        } else {
            return 9;
        }
    }
}
