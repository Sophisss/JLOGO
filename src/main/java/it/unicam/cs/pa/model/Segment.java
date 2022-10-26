package it.unicam.cs.pa.model;

import java.util.LinkedList;

public class Segment implements I_Segment{

    private final LinkedList<Coordinate> segment = new LinkedList<>();

    private Color color;

    private int size;

    public Segment(Coordinate start, Coordinate end) {
        segment.add(start);
        segment.add(end);
        this.color = Color.BLACK;
    }

    @Override
    public LinkedList<Coordinate> getCoordinates() {
        return segment;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public void setColor(Color color) {
        this.color=color;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public void setSize(int size) {
        if(size<1)
            throw new IllegalArgumentException("Valore errato");
        this.size=size;
    }

    @Override
    public Coordinate getFirst() {
        return getCoordinates().getFirst();
    }

    @Override
    public Coordinate getLast() {
        return getCoordinates().getLast();
    }

    @Override
    public String toString() {
        return "LINE <" + segment.getFirst().getX() + "> <" + segment.getFirst().getY() + "> <" + segment.getLast().getX() +
                "> <" + segment.getLast().getY() + "> " + getColor().toString() + "<" + getSize() + "> ";
    }
}
