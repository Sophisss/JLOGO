package it.unicam.cs.pa.model;

import java.util.LinkedList;
import java.util.Set;

/**
 * Rappresenta il foglio su cui andremo a disegnare.
 *  Un foglio &egrave; rappresentato da una base ed un'altezza di tipo <code>double</code>.
 *  Conterr&agrave; l'insieme dei disegni.
 */

public interface I_Paper{

    /**
     * Questo metodo ritorna la base del foglio.
     * @return base del foglio.
     */
    Double getBase();

    /**
     * Questo metodo ritorna l'altezza del foglio.
     * @return altezza del foglio.
     */
    Double getHeight();

    /**
     * Questo metodo ritorna il colore dello sfondo dell'area di disegno.
     * @return colore dello sfondo dell'area di disegno
     */
    Color getBackground();

    /**
     * Questo metodo imposta il colore dello sfondo dell'area di disegno al colore passato come parametro.
     * @param color colore passato come parametro.
     */
    void setBackground(Color color);

    /**
     * Mi ritorna ci&ograve; che ho disegnato nel paper.
     * @return ci&ograve; che ho disegnato nel paper.
     */
    Set<LinkedList<Segment>> getDraw();

    /**
     * Mi ritorna l'insieme dei poligoni disegnati.
     * @return tutti i poligoni disegnati.
     */
    Set<Polygon<Segment>> getPolygons();

    /**
     * Aggiunge al disegno nel paper i nuovi disegni.
     */
    void addToDraw(LinkedList<Segment> isDraw);

    /**
     * Aggiunge all'insieme dei poligoni, il poligono passato.
     * @param pol poligono passato come parametro.
     */
    void addToPolygons(Polygon<Segment> pol);

    /**
     * Questo metodo cancella tutto il foglio di disegno.
     */
    void clear();

    /**
     * Verifica se una determinata posizione rientra nei limiti del paper.
     * @param coordinate la posizione data.
     * @return <code>true</code> se la posizione si trova all'interno del paper,
     * <code>false</code> altrimenti.
     */
    boolean isWithinBounds(Coordinate coordinate);

    /**
     * Questo metodo ritorna la posizione centrale dell'area di disegno.
     * @return posizione centrale dell'area di disegno.
     */
    default Coordinate getHome() {
        return new Coordinate(getBase()/2, getHeight()/2);
    }
}
