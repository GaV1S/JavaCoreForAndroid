package Homework8Re;

public class Runway implements Accepting{
    private String name;
    private int distance;

    public Runway(String name, int distance) {
        this.name = name;
        this.distance = distance;
    }

    @Override
    public int getOption() { return distance; }

    @Override
    public String printOption() { return "Длина " + name + " - " + distance + " м."; }

}