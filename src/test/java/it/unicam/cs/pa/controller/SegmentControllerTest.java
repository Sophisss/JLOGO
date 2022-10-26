package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Coordinate;
import it.unicam.cs.pa.model.Segment;
import org.junit.jupiter.api.Test;
import java.util.LinkedList;

class SegmentControllerTest{

    SegmentController<Segment> segmentController= new SegmentController<>();

    @Test
    public void testSegmentController(){
        LinkedList<Segment> toAdd = new LinkedList<>();
        LinkedList<Segment> list = new LinkedList<>();
        Segment s1 = new Segment(new Coordinate(0,3), new Coordinate(4,4));
        Segment s2 = new Segment(new Coordinate(4,4), new Coordinate(8,8));
        Segment s3 = new Segment(new Coordinate(8,8), new Coordinate(2,6));
        Segment s4 = new Segment(s3.getLast(), new Coordinate(0,3));
        toAdd.add(s1);
        toAdd.add(s2);
        list.add(s3);
        list.add(s4);
        System.out.println(segmentController.join(toAdd,list));
        System.out.println(segmentController.checkPossibleIntersections(toAdd));
        System.out.println(segmentController.checkIfClosed(toAdd));

        Segment s5 = new Segment(s1.getFirst(), new Coordinate(-1, 3));
        LinkedList<Segment> linkedList = new LinkedList<>();
        linkedList.add(s5);
        System.out.println(segmentController.join(toAdd, linkedList));
    }

    @Test
    public void createPolygon(){
        LinkedList<Segment> toReturn = new LinkedList<>();
        Segment s1 = new Segment(new Coordinate(0,3), new Coordinate(5,5));
        Segment s2 = new Segment(new Coordinate(5,5), new Coordinate(8,8));
        Segment s3 = new Segment(new Coordinate(4,8), new Coordinate(0,3));
        toReturn.add(s1);
        toReturn.add(s2);
        toReturn.add(s3);
        System.out.println(segmentController.checkIfClosed(toReturn));
    }
}