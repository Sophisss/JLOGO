/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.pa;

import it.unicam.cs.pa.controller.PaperController;
import it.unicam.cs.pa.model.Utility.Angle;
import it.unicam.cs.pa.model.Utility.Direction;
import it.unicam.cs.pa.model.Color;
import it.unicam.cs.pa.model.Cursor;
import it.unicam.cs.pa.model.Paper;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        System.out.println("LOGO APPLICATION");
        showMainMenu();
    }
    public static void showMainMenu() {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisci altezza del foglio:");
        double first = scanner.nextDouble();
        System.out.println("Inserisci base del foglio:");
        double last = scanner.nextDouble();
        Paper init = new Paper(first, last);
        System.out.println("Foglio di disegno creato");
        System.out.println("Si vuole inserire lo sfondo del foglio? (1-si/2-no)");
        int choice = scanner.nextInt();
        if (choice == 1) {
            colorPaper(init);
        }

        PaperController paperController = new PaperController(init, new Cursor(init, 0, 2));
        System.out.println("Iniziare a disegnare? (1-si/2-no)");
        int choice1 = scanner.nextInt();
        if(choice1==1)
            toDraw(paperController);

        saveFile(paperController);
        System.out.println("Programma terminato");
    }


    private static void colorPaper(Paper paper){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Inserire il colore: ");
        String color = scanner.next();
        if (color.equals("red"))
            paper.setBackground(Color.RED);
        if (color.equals("black"))
            paper.setBackground(Color.BLACK);
        if (color.equals("white"))
            paper.setBackground(Color.WHITE);
        if (color.equals("yellow"))
            paper.setBackground(Color.YELLOW);
        if (color.equals("blue"))
            paper.setBackground(Color.BLUE);
        if (color.equals("green"))
            paper.setBackground(Color.GREEN);
        if (color.equals("orange"))
            paper.setBackground(Color.ORANGE);

        System.out.println("Sfondo applicato");

    }

    private static void toDraw(PaperController paperController) {
        final Scanner scanner = new Scanner(System.in);
        System.out.println("Si vuole cambiare il colore del segmento? 1-si/2-no");
        int choice = scanner.nextInt();
        if(choice==1) {
            Color color = colorLine();
            paperController.getCursor().setLine(color);
        }
        System.out.println("Si vuole cambiare lo spessore del segmento? 1-si/2-no");
        int c = scanner.nextInt();
        if(c==1) {
            System.out.println("Inserire lo spessore: ");
            int size = scanner.nextInt();
            paperController.getCursor().setSize(size);
        }
        paperController.penDown();
        System.out.println("Inserire la distanza: ");
        double distance = scanner.nextDouble();
        System.out.println("Inserire l'ampiezza dell'angolo: ");
        int angleValue = scanner.nextInt();
        System.out.println("Inserire la direzione: (1-forward/-1 -backward)");
        int direction = scanner.nextInt();
        System.out.println("Inserire l'angolo: (1-left/-1 -right)");
        int angle = scanner.nextInt();
        if(direction==1){
            if (angle==1){
                paperController.draw(Direction.FORWARD, distance, Angle.LEFT, angleValue);
            } else
                paperController.draw(Direction.FORWARD, distance, Angle.RIGHT, angleValue);
        }else {
            if(angle==1)
                paperController.draw(Direction.BACKWARD, distance, Angle.LEFT, angleValue);
            else
                paperController.draw(Direction.BACKWARD, distance, Angle.RIGHT, angleValue);
        }
        paperController.check();
        System.out.println("Disegnato");
        paperController.penUp();

        System.out.println("Vuoi continuare a disegnare: (1-si/2-no)");
        int choice1 = scanner.nextInt();
        if (choice1 == 1)
            toDraw(paperController);
    }

    private static Color colorLine(){
        final Scanner scanner = new Scanner(System.in);
        Color toReturn = null;
        System.out.println("Inserire il colore: ");
        String color = scanner.next();
        if (color.equals("red"))
            toReturn = Color.RED;
        if (color.equals("black"))
            toReturn = Color.BLACK;
        if (color.equals("white"))
            toReturn = Color.WHITE;
        if (color.equals("yellow"))
            toReturn = Color.YELLOW;
        if (color.equals("blue"))
            toReturn = Color.BLUE;
        if (color.equals("green"))
            toReturn = Color.GREEN;
        if (color.equals("orange"))
            toReturn = Color.ORANGE;

        return toReturn;
    }
    private static void saveFile(PaperController paperController){
        final Scanner scanner = new Scanner(System.in);
        System.out.println("vuoi salvare il file: (1-si/2-no)");
        int save = scanner.nextInt();
        if(save==1) {
            System.out.println("Inserire il nome del file: ");
            String name = scanner.next();
            paperController.saveAsFile(name);
        }
    }
}
