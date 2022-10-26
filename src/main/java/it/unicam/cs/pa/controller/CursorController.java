package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Utility.Angle;
import it.unicam.cs.pa.model.Utility.Direction;
import it.unicam.cs.pa.model.*;

public class CursorController {

    /**
     * Calcola la nuova posizione del cursore passato,
     * passando la direzione verso cui andare, la distanza e l'angolo.
     */
    public void computeNewPosition(Cursor cursor, Direction direction, double distance, Angle angle, int angleValue){
        int newAngle = computeAngle(cursor.getDirection(), angle, angleValue);
        double newXValue = cursor.getPosition().getX() + (distance * direction.getSign()) * Math.cos(Math.toRadians(newAngle));
        double newYValue = cursor.getPosition().getY() + (distance * direction.getSign()) * Math.sin(Math.toRadians(newAngle));
        Coordinate coordinate = new Coordinate((double) Math.round(newXValue), (double) Math.round(newYValue));

        if(cursor.getPaper().isWithinBounds(coordinate))
            throw new IllegalArgumentException("Il cursore deve trovarsi all'interno del paper");

        cursor.setPosition(coordinate);
        cursor.setDirection(newAngle);
    }

    /**
     * Imposta se il cursore sta tracciando o meno un segmento.
     */
    public void setPlot(Cursor cursor, boolean isPlot) {
        cursor.setPlot(isPlot);
    }

    /**
     * Imposta il colore del cursore al colore passato come parametro.
     */
    public void setPenColor(Cursor cursor, Color color) {
        cursor.setLine(color);
    }

    /**
     * Imposta la grandezza del tratto del cursore.
     */
    public void setPenSize(Cursor cursor, int size){
        cursor.setSize(size);
    }

    /**
     * Calcola l'angolo a cui &egrave; posizionato il cursore.
     * @return l'angolo a cui &egrave; posizionato il cursore.
     */
    private int computeAngle(int currentDirection, Angle angle, int angleValue) {
        if (angle == Angle.RIGHT) {
            if (currentDirection - angleValue < 0) {
                return 360 + currentDirection - angleValue;
            } else {
                return currentDirection - angleValue;
            }
        }
        return currentDirection + angleValue;
    }
}
