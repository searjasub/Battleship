package edu.neumont.lopez.battleship.model;

public class Square {

    private String printValue;
    private Player owner;

    public String getPrintValue() {
        return printValue;
    }

    public void setPrintValue(String printValue) {
        this.printValue = printValue;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }
}
