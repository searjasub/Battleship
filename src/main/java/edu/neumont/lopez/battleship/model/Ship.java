package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.enumeration.State;

public class Ship {
    private final String name;
    private final int size;
    private int lives;
    private boolean isSunk;


    Ship(Ships ship) {
        this.name = ship.getName();
        this.size = ship.getSize();
        this.isSunk = false;
        this.lives = size;
    }

    public String getName() {
        return name;
    }

    public int getSize() {
        return size;
    }

    public boolean isSunk() {
        return isSunk;
    }

    public void setSunk(boolean sunk) {
        isSunk = sunk;
    }

    public void shipHitted() {
        if (lives == 0) {
            isSunk = true;
            System.out.println("You sunk the " + name);
            return;
        }
        lives--;
    }
}
