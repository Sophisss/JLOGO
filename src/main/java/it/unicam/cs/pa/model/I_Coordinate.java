package it.unicam.cs.pa.model;

/**
 * Rappresenta un punto nell'area di disegno;
 * &egrave; formato da due parametri di tipo <code>double</code> x e y.
 */

public interface I_Coordinate {

    /**
     * Ritorna il punto x.
     * @return il punto x.
     */
    double getX();

    /**
     * Ritorna il punto y.
     * @return il punto y.
     */
    double getY();
}
