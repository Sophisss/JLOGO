package it.unicam.cs.pa.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.LinkedList;

class ArchTest {

    @Test
    public void testArchConstructor(){
        LinkedList<Segment> toAdd = new LinkedList<>();
        Segment s1 = new Segment(new Coordinate(2,2), new Coordinate(4,4));
        Segment s2 = new Segment(new Coordinate(4,4), new Coordinate(8,8));
        toAdd.add(s1);
        toAdd.add(s2);
        Arch arch = new Arch(toAdd);
        assertEquals(toAdd, arch.getLinkedList());
        assertEquals(arch.getCoordinates().getFirst(), arch.getFirst());
        assertEquals(arch.getCoordinates().getLast(), arch.getLast());
        arch.setColor(Color.GREEN);
        assertEquals(Color.GREEN, arch.getColor());

        try {
            arch.setSize(2);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        System.out.println(arch.getLinkedList());
    }
}