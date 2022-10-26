package it.unicam.cs.pa.model;

public class Cursor implements I_Cursor{

    private Coordinate position;

    private final Paper paper;

    private int direction;

    private Color line;

    private boolean plot;

    private int size;

    public Cursor(Paper paper, int direction, int size) {
        this.position = paper.getHome();
        // La direzione dell'angolo vive nell'intervallo [ 0 - 360 ]
        if (direction < 0 || direction > 360) {
            throw new IllegalArgumentException("Non si possono superare i 360 gradi");
        }
        this.direction = direction;
        this.size = size;
        this.line = Color.BLACK;
        this.position = paper.getHome();
        this.paper=paper;
    }

    @Override
    public Coordinate getPosition() {
        return this.position;
    }

    @Override
    public void setPosition(Coordinate position) {
        if(paper.isWithinBounds(position))
            throw new IllegalArgumentException("Il cursore deve trovarsi all'interno del paper");
        this.position=position;
    }

    @Override
    public int getDirection() {
        return this.direction;
    }

    @Override
    public void setDirection(int direction) {
        if (direction < 0 || direction > 360)
            throw new IllegalArgumentException("Non si possono superare i 360 gradi");
        this.direction=direction;
    }

    @Override
    public Color getLine() {
        return this.line;
    }

    @Override
    public void setLine(Color line) {
        this.line=line;
    }

    @Override
    public boolean isPlot() {
        return plot;
    }

    @Override
    public void setPlot(boolean plot) {
        this.plot=plot;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        if(size<1)
            throw new IllegalArgumentException("Valore errato");
        this.size = size;
    }

    @Override
    public Paper getPaper(){
        return this.paper;
    }
}
