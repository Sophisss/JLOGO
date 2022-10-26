package it.unicam.cs.pa.model;

public class Movements implements Commands{

    private final Cursor cursor;

    private final Paper paper;

    private final Polygon polygon;

    public Movements(Cursor cursor, Polygon polygon) {
        this.cursor = cursor;
        this.paper=cursor.getPaper();
        this.polygon=polygon;
    }


    @Override
    public void clearscreen() {
        this.paper.clear();
    }

    @Override
    public void home() {
        this.cursor.setPosition(this.paper.getHome());
    }

    @Override
    public void penUp() {
        this.cursor.setPlot(false);
    }

    @Override
    public void penDown() {
        this.cursor.setPlot(true);
    }

    @Override
    public void setPenColor(Color color) {
        this.cursor.setLine(color);
    }

    @Override
    public void setFillColor(Color color) {
        this.polygon.setBackground(color);
    }

    @Override
    public void setScreenColor(Color color) {
        this.paper.setBackground(color);
    }

    @Override
    public void setPenSize(int size) {
        this.cursor.setSize(size);
    }
}
