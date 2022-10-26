package it.unicam.cs.pa.model;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Paper implements I_Paper{

    private final double base;

    private final double height;

    private Color background;

    private final Set<LinkedList<Segment>> draw;

    private final Set<Polygon<Segment>> polygons;

    public Paper(double base, double height) {
        if((this.height = height) < 0 || (this.base = base) < 0 )
            throw new IllegalArgumentException("Errore nell'inserimento di base e/o altezza");
        this.background = Color.WHITE;
        this.draw = new HashSet<>();
        this.polygons = new HashSet<>();
    }

    @Override
    public Double getBase() {
        return this.base;
    }

    @Override
    public Double getHeight() {
        return this.height;
    }

    @Override
    public Color getBackground() {
        return this.background;
    }

    @Override
    public void setBackground(Color color) {
        this.background = color;
    }

    @Override
    public Set<LinkedList<Segment>> getDraw(){
        return this.draw;
    }

    @Override
    public Set<Polygon<Segment>> getPolygons() {
        return this.polygons;
    }

    @Override
    public void addToDraw(LinkedList<Segment> isDraw){
        this.draw.add(isDraw);
    }

    @Override
    public void addToPolygons (Polygon<Segment> pol) {
        this.polygons.add(pol);
    }

    @Override
    public void clear() {
        this.draw.clear();
        this.polygons.clear();
        setBackground(Color.WHITE);
    }

    @Override
    public boolean isWithinBounds(Coordinate coordinate) {
        double x = coordinate.getX();
        double y = coordinate.getY();

        return (!(x >= 0) || !(x <= getBase())) || (!(y >= 0) || !(y <= getHeight()));
    }
}
