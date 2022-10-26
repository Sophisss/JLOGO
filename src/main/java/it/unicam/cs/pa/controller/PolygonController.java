package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Color;
import it.unicam.cs.pa.model.I_Segment;
import it.unicam.cs.pa.model.Polygon;

public class PolygonController<T extends I_Segment> {

    public void setFillColor(Polygon<T> polygon, Color color){
        polygon.setBackground(color);
    }
}
