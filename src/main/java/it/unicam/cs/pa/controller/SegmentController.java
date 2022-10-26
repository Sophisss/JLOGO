package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Coordinate;
import it.unicam.cs.pa.model.I_Segment;
import it.unicam.cs.pa.model.Polygon;
import java.util.LinkedList;

public class SegmentController<T extends I_Segment> {

    /**
     * Serve per fare l'unione tra due segmenti.
     */
    public LinkedList<T> join(LinkedList<T> sl1, LinkedList<T> sl2) {
        if (checkIfClosed(sl1) == null && checkIfClosed(sl2) == null) {
            if (checkJoin(sl1, sl2)) {
                sl1.addAll(sl2);
                return sl1;
            }
        }
        return null;
    }

    /**
     * Controlla se due liste concatenate di segmenti si possono unire.
     * @return <code>true</code> se si possono unire, <code>false</code> altrimenti.
     */
    private boolean checkJoin(LinkedList<T> sl1, LinkedList<T> sl2) {
        return sl1.getFirst().getFirst().equals(sl2.getLast().getFirst()) ||
                sl1.getFirst().getFirst().equals(sl2.getLast().getLast()) ||
                sl1.getLast().getLast().equals(sl2.getFirst().getFirst()) ||
                sl1.getLast().getFirst().equals(sl2.getFirst().getLast());
    }

    /**
     * Controlla se la lista di segmenti crea un poligono.
     * @return un nuovo poligono, <code>null</code> altrimenti.
     */
    public Polygon<T> checkIfClosed(LinkedList<T> list) {
        if (isConsecutive(list)) {
            return new Polygon<>(list);
        }
        return null;
    }

    /**
     * Scorre la linkedlist di segmenti e se non sono uguali,
     * controlla se i due segmenti si intersecano ed eventualmente calcola il punto di intersezione.
     * @return il punto di intersezione, <code>null</code> altrimenti.
     */
    public Coordinate checkPossibleIntersections(LinkedList<T> currentSegments) {
        for (T current : currentSegments) {
            for (T other : currentSegments) {
                if (!current.equals(other)) {
                    return lineIntersection(current,other);
                }
            }
        }
        return null;
    }

    /**
     * Questo metodo mi calcola le coordinate del punto di intersezione
     * tra due segmenti se questi si intersecano.
     * @return le coordinate del punto di intersezione, <code>null</code> altrimenti.
     */
    private Coordinate lineIntersection(T s1, T s2) {
        double a1 = s1.getLast().getY() - s1.getFirst().getY();
        double b1 = s1.getFirst().getX() - s1.getLast().getX();
        double c1 = a1 * s1.getFirst().getX() + b1 * s1.getFirst().getY();

        double a2 = s2.getLast().getY() - s2.getFirst().getY();
        double b2 = s2.getFirst().getX() - s2.getLast().getX();
        double c2 = a2 * s2.getFirst().getX() + b2 * s2.getFirst().getY();

        double toIntersect = a1 * b2 - a2 * b1;

        if (toIntersect == 0) {
            return null;
        } else {
            double x = (b2 * c1 - b1 * c2) / toIntersect;
            double y = (a1 * c2 - a2 * c1) / toIntersect;
            return new Coordinate(x, y);
        }
    }

    /**
     * Controlla se tutti gli elementi di una linkedlist sono consecutivi.
     * @param list linkedlist passata come parametro.
     * @return <code>true</code> se sono consecutivi, <code>false</code> altrimenti.
     */
    private boolean isConsecutive(LinkedList<T> list){
        int count = 0;
        for(T element : list){
            for(T other : list){
                if(element.getLast().equals(other.getFirst()))
                    count++;
            }
        }
        return count == list.size();
    }
}
