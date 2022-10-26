package it.unicam.cs.pa.model.Utility;

/**
 * Rappresenta la direzione verso cui deve disegnare il cursore
 * e pu&ograve; spostarsi in avanti o indietro.
 */

public enum Direction {
    FORWARD(1), BACKWARD(-1);

    private final int sign;

    Direction(int sign){
        this.sign=sign;
    }

    public int getSign(){
        return this.sign;
    }
}
