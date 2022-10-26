package it.unicam.cs.pa.model;

import java.util.LinkedList;

public class Polygon<T> implements I_Polygon<T>{

    private Color background;

    private final LinkedList<T> linkedList = new LinkedList<>();

    public Polygon(LinkedList<T> list) {
        this.linkedList.addAll(list);
        this.background = Color.WHITE;
    }

    @Override
    public void setBackground(Color color) {
        this.background = color;
    }

    @Override
    public Color getBackground() {
        return this.background;
    }

    @Override
    public LinkedList<T> getLinkedList() {
        return this.linkedList;
    }

    @Override
    public String toString() {
        return "\n"+"POLYGON <" + this.linkedList.size() + "> " + getBackground().toString() + print() + "\n";
    }

    private String print(){
        StringBuilder toReturn= new StringBuilder();
        for(T element: linkedList){
            toReturn.append("\n").append(" ").append(element.toString());
        }
        return toReturn.toString();
    }
}
