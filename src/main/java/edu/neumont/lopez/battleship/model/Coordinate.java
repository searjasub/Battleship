package edu.neumont.lopez.battleship.model;

public class Coordinate {

    private int row;
    private int column;

    public Coordinate(int row, int col) {
        this.setRow(row);
        this.setColumn(col);
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
