package it.unicam.cs.pa.model;

import java.util.LinkedList;

/**
 * Rappresenta un insieme di linee che formano un area chiusa.
 */
public interface I_Polygon<T> {

    /**
     * Imposta il colore di sfondo del poligono al colore passato come parametro.
     */
    void setBackground(Color color);

    /**
     * Mi ritorna il colore di sfondo del poligono.
     * @return il colore di sfondo del poligono.
     */
    Color getBackground();

    /**
     * Metodo che mi ritorna l'insieme dei segmenti che creano il poligono.
     * @return l'insieme dei segmenti che creano il poligono.
     */
    LinkedList<T> getLinkedList();

}
