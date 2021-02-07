package Homework6;

public class Dog extends Animal {

    final int DISTANCE_FOR_RUN = 500;
    final int DISTANCE_FOR_SWIM = 10;

    public Dog(String name) {
        super(name);
    }

    @Override
    public String run(int distance) {
        if (distance <= DISTANCE_FOR_RUN)
            return (super.getName() + " пробежал " + distance + "м");
        else
            return (super.getName() + " пробежал " + DISTANCE_FOR_RUN + "м и устал");
    }

    @Override
    public String swim(int distance) {
        if (distance <= DISTANCE_FOR_SWIM)
            return (super.getName() + " проплыл " + distance + "м");
        else
            return (super.getName() + " проплыл " + DISTANCE_FOR_SWIM + "м и устал");
    }
}