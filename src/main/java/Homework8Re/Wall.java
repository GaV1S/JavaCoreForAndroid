package Homework8Re;

public class Wall implements Accepting{
    private String name;
    private int height;

    public Wall(String name, int height) {
        this.name = name;
        this.height = height;
    }

    @Override
    public int getOption() { return height; }

    @Override
    public String printOption() { return "Высота " + name + " - " + height + " м."; }

}
