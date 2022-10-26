package it.unicam.cs.pa.model;

import java.util.LinkedList;

public class Arch implements I_Segment{

    private final LinkedList<Segment> linkedList = new LinkedList<>();

    private Color color;

    private int size;

    public Arch(LinkedList<Segment> list){
        linkedList.addAll(list);
    }

    @Override
    public LinkedList<Coordinate> getCoordinates() {
        LinkedList<Coordinate> toReturn = new LinkedList<>();
        toReturn.add(this.linkedList.getFirst().getFirst());
        toReturn.add(this.linkedList.getLast().getLast());
        return toReturn;
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
        return this.linkedList.getFirst().getFirst();
    }

    @Override
    public Coordinate getLast() {
        return this.linkedList.getLast().getLast();
    }

    public LinkedList<Segment> getLinkedList() {
        return this.linkedList;
    }

    @Override
    public String toString() {
        return print();
    }

    private String print() {
        StringBuilder toReturn = new StringBuilder();
        for(Segment segment: linkedList){
            toReturn.append(segment.toString()).append("\n");
        }
        return toReturn.toString();
    }
}
