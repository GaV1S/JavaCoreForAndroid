package Homework11;

import Homework11.fruit.Fruit;
import Homework11.fruit.TypeFruit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Box<T extends Fruit & TypeFruit> {

    private static final float ACCURACY = 0.001f;

    private final List<T> container;

    private int capacity;

    public Box(int capacity, T ...fruits){
        this.container = new ArrayList<>(Arrays.asList(fruits));
        this.capacity = capacity;
    }

    public float getWeight() {
        float thisWeight = 0.0f;

        for (T fruit : container) {
            thisWeight += fruit.getWeight();
        }

        return thisWeight;
    }

    public void transferFruitsToAnotherBox(Box<T> anotherBox){
        if (anotherBox == this) return;

        int countSize = Math.min(container.size(), anotherBox.capacity);
        List<T> fruits = container.subList(0, countSize);
        anotherBox.container.addAll(fruits);
        container.removeAll(fruits);

        anotherBox.capacity -= countSize;
        capacity += countSize;
    }

    public boolean compare(Box<?> anotherBox){
       return Math.abs(this.getWeight() - anotherBox.getWeight()) <ACCURACY;
    }

    public void addFruit(T fruit) {
        if (capacity - 1 > 0) {
            container.add(fruit);
            capacity--;
        }
    }

}
