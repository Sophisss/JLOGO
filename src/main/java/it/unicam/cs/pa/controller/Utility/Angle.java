package it.unicam.cs.pa.model.Utility;

/**
 * Rappresenta la direzione dell'angolo verso cui
 * pu&ograve; disegnare il cursore e
 * pu&ograve; essere verso sinistra o verso dentra.
 */

public enum Angle {

    LEFT(1), RIGHT(-1);

    private final int sign;

    Angle(int sign){
        this.sign=sign;
    }

    public int getSign(){
        return this.sign;
    }
}
