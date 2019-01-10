package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.State;

public class Square {

    private State state = State.EMPTY;

    public Square() {
    }

    public char getPrintValue() {
        return state.getStatus();
    }

    public void setState(State state) {
        this.state = state;
    }
}
