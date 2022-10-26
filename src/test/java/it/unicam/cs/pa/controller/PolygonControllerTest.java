package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Color;
import it.unicam.cs.pa.model.Coordinate;
import it.unicam.cs.pa.model.Polygon;
import it.unicam.cs.pa.model.Segment;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class PolygonControllerTest {

    PolygonController<Segment> polygonController = new PolygonController<>();

    @Test
    public void testFillColor() {
        LinkedList<Segment> toReturn = new LinkedList<>();
        Segment s1 = new Segment(new Coordinate(2,2), new Coordinate(5,5));
        Segment s2 = new Segment(s1.getLast(), new Coordinate(3, 8));
        Segment s3 = new Segment(s2.getLast(), s1.getFirst());
        toReturn.add(s1);
        toReturn.add(s2);
        toReturn.add(s3);
        Polygon<Segment> polygon = new Polygon<>(toReturn);
        polygon.setBackground(Color.GREEN);
        assertEquals(Color.GREEN, polygon.getBackground());
        polygonController.setFillColor(polygon, Color.ORANGE);
        assertEquals(Color.ORANGE, polygon.getBackground());
        System.out.println(polygon);
    }
}