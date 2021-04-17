package Homework6;

public class Animal {
    private String name;

    public Animal (String name){
        this.name = name;
    }

    public String run(int distance) {
                return (this.name + " пробежал " + distance + "м");
    }

    public String swim(int distance) {
                return (this.name + " проплыл " + distance + "м");
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}