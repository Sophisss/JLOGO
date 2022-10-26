package it.unicam.cs.pa.model;

public interface Commands {

    void clearscreen();

    void home();

    void penUp();

    void penDown();

    void setPenColor(Color color);

    void setFillColor(Color color);

    void setScreenColor(Color color);

    void setPenSize(int size);
}
