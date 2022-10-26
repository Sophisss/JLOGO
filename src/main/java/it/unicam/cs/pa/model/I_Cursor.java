package it.unicam.cs.pa.model;

/**
 * Ha la responsabilit&agrave; di eseguire specifiche istruzioni al fine di
 * creare dei disegni.
 * Un cursore &egrave; rappresentato da delle coordinate ed
 * &egrave; posizionato nel paper.
 */
public interface I_Cursor {

    /**
     * Questo metodo ritorna la posizione del cursore.
     * @return la posizione del cursore.
     */
    Coordinate getPosition();

    /**
     * Imposta la posizione del cursore nella posizione rappresentata dalle coordinate passate come parametro.
     */
    void setPosition(Coordinate position);

    /**
     * Questo metodo ritorna l'angolo verso cui &egrave; puntato il cursore.
     * @return l'angolo verso cui è puntato il cursore.
     */
    int getDirection();

    /**
     * Imposta l'angolo verso cui &egrave; puntato il cursore all'angolo passato come parametro.
     */
    void setDirection(int direction);

    /**
     * Questo metodo ritorna il colore della linea che traccer&agrave; il cursore.
     * @return il colore della linea che traccer&agrave; il cursore.
     */
    Color getLine();

    /**
     * Imposta il colore della linea che traccer&agrave; il cursore al colore passato come parametro.
     */
    void setLine(Color line);

    /**
     * Questo metodo mi ritorna <code>true</code> se il cursore sta disegnando un segmento,
     * altrimenti <code>false</code> se il cursore non sta disegnando un segmento.
     * @return <code>true</code> se il cursore sta disegnando un segmento,
     * altrimenti <code>false</code> se il cursore non sta disegnando un segmento.
     */
    boolean isPlot();

    /**
     * Imposta se il cursore sta tracciando un segmento oppure no attraverso il parametro passato.
     */
    void setPlot(boolean plot);

    /**
     * Questo metodo ritorna lo spessore del tratto del cursore.
     * @return lo spessore del tratto del cursore.
     */
    int getSize();

    /**
     * Imposta lo spessore del tratto del cursore con la grandezza passata come parametro.
     */
    void setSize(int size);


    /**
     * Questo metodo mi ritorna il mio paper.
     * @return il mio paper.
     */
    Paper getPaper();
}

