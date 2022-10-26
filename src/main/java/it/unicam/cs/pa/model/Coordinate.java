package it.unicam.cs.pa.model;

public record Coordinate(double x, double y) implements I_Coordinate {

    @Override
    public double getX() {
        return this.x;
    }

    @Override
    public double getY() {
        return this.y;
    }
}
