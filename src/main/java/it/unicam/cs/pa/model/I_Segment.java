package it.unicam.cs.pa.model;

import java.util.LinkedList;

/**
 * Mi rappresenta un segmento disegnato dal cursore.
 * &Egrave; formato da un insieme di coordinate che rappresentano
 * dove inizia e dove termina il segmento.
 */
public interface I_Segment {

    /**
     * Questo metodo ritorna le coordinate del segmento.
     * @return le coordinate del segmento.
     */
    LinkedList<Coordinate> getCoordinates();

    /**
     * Questo metodo ritorna il colore del segmento disegnato.
     * @return il colore del segmento disegnato.
     */
    Color getColor();

    /**
     * Imposta il colore del segmento al colore passato
     * come parametro.
     */
    void setColor(Color color);

    /**
     * Questo metodo mi ritorna lo spessore del segmento disegnato.
     * @return lo spessore del segmento disegnato.
     */
    int getSize();

    /**
     * Imposta lo spessore del segmento con quello passato
     * come parametro.
     */
    void setSize(int size);

    /**
     * Mi ritorna la prima coordinata che indica l'inizio del segmento.
     * @return la prima coordinata del segmento.
     */
    Coordinate getFirst();

    /**
     * Mi ritorna l'ultima coordinata che indica la fine del segmento.
     * @return l'ultima coordinata del segmento.
     */
    Coordinate getLast();
}
