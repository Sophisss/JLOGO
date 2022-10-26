package it.unicam.cs.pa.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

class PolygonTest {

    @Test
    public void testPolygonConstructor(){
        Segment s1 = new Segment(new Coordinate(2,2), new Coordinate(3,6));
        Segment s2 = new Segment(new Coordinate(3,6), new Coordinate(8,8));
        Segment s3 = new Segment(new Coordinate(8,8), new Coordinate(2,2));
        LinkedList<Segment> toPolygon = new LinkedList<>();
        toPolygon.add(s2);
        toPolygon.add(s3);
        Arch arch = new Arch(toPolygon);
        LinkedList<? super I_Segment> toAdd = new LinkedList<>();
        toAdd.add(s1);
        toAdd.add(arch);
        Polygon<? super I_Segment> polygon = new Polygon<>(toAdd);
        assertEquals(toAdd, polygon.getLinkedList());
        assertEquals(Color.WHITE, polygon.getBackground());
        polygon.setBackground(Color.ORANGE);
        assertEquals(Color.ORANGE, polygon.getBackground());
        System.out.println(polygon);
    }
}