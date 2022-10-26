package it.unicam.cs.pa.controller;

import org.junit.jupiter.api.Test;

class FileControllerTest {

    String currentDir = System.getProperty("user.dir") + "\\src\\main\\resources\\";
    FileController fileController = new FileController();

    @Test
    public void testFileController(){
        String name = "File.txt";
        fileController.readFile(currentDir+name);
    }
}