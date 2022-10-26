package it.unicam.cs.pa.controller;

import it.unicam.cs.pa.model.Paper;
import it.unicam.cs.pa.model.Polygon;
import it.unicam.cs.pa.model.Segment;
import java.io.*;
import java.util.LinkedList;

public class FileController {

    /**
     * Scrive sul file.
     */
    public void writeAndConfigureFile(Paper paper, String name) {
        String currentDir = System.getProperty("user.dir") + "\\src\\main\\resources\\";

        String header = "SIZE " + paper.getBase().toString() + " " + paper.getHeight().toString() + " " +
                paper.getBackground().getRed().toString() + " " + paper.getBackground().getGreen().toString() + " " +
                paper.getBackground().getBlue().toString() + " \n";
        String secondLine = "<shape>\n";
        String tail = "</shape>";

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(currentDir + name));
            bw.write(header);
            bw.write(secondLine);
            for (LinkedList<Segment> linkedList : paper.getDraw()) {
                for (Segment segment : linkedList) {
                    bw.write(" " + segment.toString() + "\n");
                }
            }
            for(Polygon list: paper.getPolygons()){
                bw.write(" " + list.toString());
            }
            bw.write(tail);
            bw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Legge il file.
     */
    public Paper readFile(String filePath) {
        Paper paper;

        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            if (line == null) {
                throw new RuntimeException("File vuoto");
            }
            double width = Double.parseDouble(extractWidth(line));
            double height = Double.parseDouble(extractHeight(line));
            System.out.println(line);
            paper = new Paper(width, height);
            line = br.readLine();
            if (line.equals("<shape>"))
                System.out.println(line);
            line = br.readLine();
            while (!line.equals("</shape>")) {
                System.out.println(line);
                line = br.readLine();
            }
            System.out.println(line);
            br.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return paper;
    }

    /**
     * Metodo che mi ritorna sotto forma di stringa la base del paper.
     * @return base del paper.
     */
    private String extractWidth(String line) {
        StringBuilder width = new StringBuilder();
        for (int i = 5; i < line.length(); i++) {
            if (line.charAt(i) == ' ') {
                break;
            }
            width.append(line.charAt(i));
        }
        return width.toString();
    }

    /**
     * Mi ritorna l'altezza sotto forma di stringa del paper.
     * @return l'altezza del paper.
     */
    private String extractHeight(String line) {
        StringBuilder height = new StringBuilder();
        int i = 0;
        int spaceOccurrences = 0;
        while (i < line.length()) {
            if (line.charAt(i) == ' ')
                spaceOccurrences++;

            if (spaceOccurrences == 2)
                height.append(line.charAt(i));
            i++;
        }
        return height.toString();
    }
}

