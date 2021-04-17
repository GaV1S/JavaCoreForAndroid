package Homework6;

public class Cat extends Animal {

    final int DISTANCE_FOR_RUN = 200;
    final int DISTANCE_FOR_SWIM = 0;

    public Cat(String name) {
        super(name);
    }

    @Override
    public String run(int distance) {
        if (DISTANCE_FOR_RUN == 0)
            return (super.getName() + " не умеет бегать");
        else
            if (distance <= DISTANCE_FOR_RUN)
                return (super.getName() + " пробежал " + distance + "м");
            else
                return (super.getName() + " пробежал " + DISTANCE_FOR_RUN + "м и устал");
    }

    @Override
    public String swim(int distance) {
        if (DISTANCE_FOR_SWIM == 0)
            return (super.getName() + " не умеет плавать");
        else
            if (distance <= DISTANCE_FOR_SWIM)
                return (super.getName() + " проплыл " + distance + "м");
            else
                return (super.getName() + " проплыл " + DISTANCE_FOR_SWIM + "м и устал");
    }
}