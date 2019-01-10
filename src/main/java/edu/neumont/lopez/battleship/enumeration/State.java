package edu.neumont.lopez.battleship.enumeration;

public enum State {
    UNHIT('S'),  //S = Ship
    HIT('H'),
    MISS('M'),
    EMPTY('~');

    private char status;

    State(char status) {
        this.setStatus(status);
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }
}
