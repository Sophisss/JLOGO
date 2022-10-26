package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Utility.Angle;
import it.unicam.cs.pa.model.Utility.Direction;
import it.unicam.cs.pa.model.Color;
import it.unicam.cs.pa.model.Cursor;
import it.unicam.cs.pa.model.Paper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CursorControllerTest {

    CursorController cursorController= new CursorController();
    Cursor cursor = new Cursor(new Paper(10, 10), 0, 2);

    @Test
    public void testComputeNewPosition(){
        cursorController.computeNewPosition(cursor, Direction.FORWARD, 4, Angle.LEFT, 0);
        assertEquals(9.0, cursor.getPosition().getX());
        assertEquals(5.0, cursor.getPosition().getY());
        cursorController.computeNewPosition(cursor, Direction.FORWARD, 4, Angle.LEFT, 90);
        assertEquals(9.0, cursor.getPosition().getX());
        assertEquals(9.0, cursor.getPosition().getY());
        cursorController.computeNewPosition(cursor, Direction.FORWARD, 4, Angle.LEFT, 90);
        assertEquals(5.0, cursor.getPosition().getX());
        assertEquals(9.0, cursor.getPosition().getY());
        cursorController.computeNewPosition(cursor, Direction.FORWARD, 4, Angle.LEFT, 90);
        assertEquals(5.0, cursor.getPosition().getX());
        assertEquals(5.0, cursor.getPosition().getY());
    }

    @Test
    public void testCursorController(){
        cursorController.setPenColor(cursor, Color.BLACK);
        assertEquals(Color.BLACK, cursor.getLine());
        try {
            cursorController.setPenSize(cursor, 3);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        assertEquals(3, cursor.getSize());
        cursorController.setPlot(cursor, true);
        assertTrue(cursor.isPlot());
    }
}