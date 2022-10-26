package it.unicam.cs.pa.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

class CursorTest {

    @Test
    public void testCursorConstructor() {
        Paper paper = new Paper(40, 40);
        Cursor cursor = new Cursor(paper, 0, 2);
        assertEquals(cursor.getPosition(), paper.getHome());
        assertEquals(0, cursor.getDirection());
        assertEquals(Color.BLACK, cursor.getLine());
        assertEquals(20, cursor.getPosition().getX());
        assertEquals(20, cursor.getPosition().getY());
        cursor.setPlot(true);
        assertTrue(cursor.isPlot());
        cursor.setLine(Color.BLUE);
        assertEquals(Color.BLUE, cursor.getLine());
        Coordinate coordinate1 = new Coordinate(5,6);
        cursor.setPosition(coordinate1);
        assertEquals(coordinate1, cursor.getPosition());
        cursor.setDirection(3);
        assertEquals(3, cursor.getDirection());

        try{
            cursor.setDirection(380);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try{
            cursor.setSize(0);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }

        try {
            cursor.setPosition(new Coordinate(45, 46));
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}