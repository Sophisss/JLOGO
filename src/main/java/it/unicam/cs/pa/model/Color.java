package it.unicam.cs.pa.model;

/**
 * Rappresenta un insieme finito di colori.
 */

public enum Color {

    WHITE(255, 255, 255), BLACK(0, 0, 0),
    GREEN(0, 255, 0), RED(255, 0, 0),
    YELLOW(255, 255, 0), BLUE(0, 0, 255), ORANGE(255, 165, 0);

    private final Integer red;

    private final Integer blue;

    private final Integer green;

    Color(Integer red, Integer blue, Integer green){
        this.red= red;
        this.blue=blue;
        this.green=green;
    }

    public Integer getRed() {
        return this.red;
    }

    public Integer getBlue(){
        return this.blue;
    }

    public Integer getGreen(){
        return this.green;
    }

    @Override
    public String toString() {
        return "<" + getRed() + "> <" + getGreen() + "> <" + getBlue() + "> ";
    }
}
