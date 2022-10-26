package it.unicam.cs.pa.model;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

class PaperTest {

    @Test
    public void testPaperConstructor(){
        Paper paper = new Paper(400, 400);
        assertEquals(400, paper.getBase());
        assertEquals(400, paper.getHeight());
        assertEquals(Color.WHITE, paper.getBackground());
        paper.setBackground(Color.ORANGE);
        assertEquals(Color.ORANGE, paper.getBackground());
        paper.clear();
        assertEquals(Color.WHITE, paper.getBackground());

        Segment s1 = new Segment(new Coordinate(2,2), new Coordinate(4,4));
        Segment s2 = new Segment(new Coordinate(5,5), new Coordinate(8,8));
        LinkedList<Segment> toAdd = new LinkedList<>();
        toAdd.add(s1);
        toAdd.add(s2);
        Arch arch = new Arch(toAdd);
        paper.addToDraw(arch.getLinkedList());
        System.out.println(paper.getDraw());
    }
}