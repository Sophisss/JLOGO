package it.unicam.cs.pa.model;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class SegmentTest {

    @Test
    public void testSegmentConstructor(){
        LinkedList<Coordinate> list = new LinkedList<>();
        Coordinate start = new Coordinate(2,1);
        Coordinate end = new Coordinate(5, 3);
        list.add(start);
        list.add(end);
        Segment segment = new Segment(start, end);
        assertEquals(start, segment.getFirst());
        assertEquals(end, segment.getLast());
        assertEquals(list, segment.getCoordinates());
        segment.setColor(Color.BLUE);
        assertEquals(Color.BLUE, segment.getColor());

        try{
            segment.setSize(4);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertEquals(4, segment.getSize());
        System.out.println(segment);
    }
}