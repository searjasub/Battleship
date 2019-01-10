package edu.neumont.lopez.battleship.model;

import edu.neumont.lopez.battleship.enumeration.Ships;
import edu.neumont.lopez.battleship.enumeration.State;

public class Ship {
    private final String name;
    private final int size;
    private final int lives;

    public Ship(Ships ship) {
        this.name = ship.getName();
        this.size = ship.getSize();
        this.lives = size;
    }

//    public State getState(){
//        if(lives == 0){
//            return State.DESTROYED;
//        } else if(lives < size){
//            return State.HITTED;
//        } else {
//            return State.MISSED;
//        }
//    }

    public String getName(){
        return name;
    }

    public int getSize(){
        return size;
    }

}
