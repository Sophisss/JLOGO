package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Utility.Angle;
import it.unicam.cs.pa.model.Utility.Direction;
import it.unicam.cs.pa.model.Color;
import it.unicam.cs.pa.model.Coordinate;
import it.unicam.cs.pa.model.Cursor;
import it.unicam.cs.pa.model.Paper;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PaperControllerTest {
    Paper paper =  new Paper(10, 10);
    PaperController paperController = new PaperController(paper, new Cursor(paper, 0, 2));

    @Test
    public void testPaperController(){
        paperController.draw(Direction.FORWARD, 4, Angle.LEFT, 0);
        paperController.draw(Direction.FORWARD, 4, Angle.LEFT, 90);
        paperController.draw(Direction.FORWARD, 4, Angle.LEFT, 90);
        paperController.draw(Direction.FORWARD, 4, Angle.LEFT, 90);
        paperController.getCursor().setPosition(new Coordinate(7,7));
        paperController.draw(Direction.FORWARD, 5, Angle.LEFT, 0);
        paperController.check();
        paperController.saveAsFile("File.txt");
        paperController.penUp();
        assertFalse(paperController.getCursor().isPlot());
        paperController.penDown();
        assertTrue(paperController.getCursor().isPlot());
        paperController.home();
        assertEquals(paperController.paper.getHome(), paperController.getCursor().getPosition());
        paperController.setScreenColor(Color.BLUE);
        assertEquals(Color.BLUE, paperController.paper.getBackground());
        paperController.clearScreen();
        assertEquals(Color.WHITE, paperController.paper.getBackground());
        assertEquals("[]", paperController.paper.getDraw().toString());
    }
}