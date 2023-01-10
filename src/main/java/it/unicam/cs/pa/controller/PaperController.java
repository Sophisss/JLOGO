package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Utility.Angle;
import it.unicam.cs.pa.model.Utility.Direction;
import it.unicam.cs.pa.model.*;
import java.util.LinkedList;

public class PaperController {

    // Segnata protected per i test
    protected final Paper paper;

    private final Cursor cursor;

    private final CursorController cursorController = new CursorController();

    private final SegmentController<Segment> segmentController = new SegmentController<>();

    private final FileController fileController = new FileController();

    public PaperController(Paper paper, Cursor cursor) {
        this.paper = paper;
        this.cursor = cursor;
    }

    /**
     * Metodo che mi crea il mio disegno.
     */
    public void draw(Direction direction, double distance, Angle angle, int angleValue) {
        LinkedList<Segment> toConfront = new LinkedList<>();

        Coordinate start = cursor.getPosition();
        cursorController.computeNewPosition(cursor, direction, distance, angle, angleValue);
        Segment segment = new Segment(start, cursor.getPosition());
        segment.setColor(cursor.getLine());
        segment.setSize(cursor.getSize());
        toConfront.add(segment);

        if(paper.getDraw().isEmpty())
            addDraw(toConfront);
        else {
            for(LinkedList<Segment> list : paper.getDraw())
                segmentController.join(list, toConfront);
        }
        if(!isPresent(toConfront))
            addDraw(toConfront);
    }

    /**
     * Mi ritorna il mio cursore.
     * @return il mio cursore.
     */
    public Cursor getCursor() {
        return this.cursor;
    }

    /**
     * Metodo che alza il cursore dal foglio.
     */
    public void penUp() {
        cursorController.setPlot(cursor, false);
    }

    /**
     * Metodo che appoggia il cursore al foglio.
     */
    public void penDown() {
        cursorController.setPlot(cursor, true);
    }

    /**
     * Cancella tutto quello che &egrave; stato disegnato.
     */
    public void clearScreen() {
        paper.clear();
    }

    /**
     * Posiziona il cursore nella posizione di home.
     */
    public void home() {
        cursor.setPosition(paper.getHome());
    }

    /**
     * Imposta il colore di sfondo dell'area di disegno al colore passato come parametro.
     */
    public void setScreenColor(Color color) {
        paper.setBackground(color);
    }

    /**
     * Salva il file e scrive su di esso.
     */
    public void saveAsFile(String name){
        fileController.writeAndConfigureFile(this.paper, name);
    }

    /**
     * Controlla se nel mio disegno ci sono dei poligoni e dei segmenti
     * che si intersecano.
     */
    public void check() {
        for (LinkedList<Segment> list : paper.getDraw()) {
            if (segmentController.checkIfClosed(list) != null) {
                if (!polygonIsPPresent(segmentController.checkIfClosed(list)))
                    addPol(segmentController.checkIfClosed(list));
            }
            segmentController.checkPossibleIntersections(list);
        }
    }

    /**
     * Controlla se un insieme di segmenti &egrave; presente all'interno del disegno.
     * @return <code>true</code> se &egrave; presente, <code>false</code> altrimenti.
     */
    private boolean isPresent(LinkedList<Segment> list){
        for(LinkedList<Segment> toIterator : paper.getDraw()){
            for(Segment segment: toIterator){
                for(Segment segment1: list){
                    if(segment.equals(segment1))
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Aggiunge i segmenti che disegno al paper.
     */
    private void addDraw(LinkedList<Segment> linkedList) {
        paper.addToDraw(linkedList);
    }

    /**
     * Aggiunge i poligoni che disegno.
     * @param polygon poligono che ho disegnato.
     */
    private void addPol(Polygon<Segment> polygon) {paper.addToPolygons(polygon);}

    /**
     * Controlla se un poligono &egrave; presente nell'insieme dei poligoni.
     * @param polygon poligono passato come parametro.
     * @return <code>true</code> se il poligono &egrave; presente, <code>false</code> altrimenti.
     */
    private boolean polygonIsPPresent(Polygon<Segment> polygon){
        for(Polygon<Segment> polygon1 : paper.getPolygons()){
            if(polygon.equals(polygon1))
                return true;
        }
        return false;
    }
}
