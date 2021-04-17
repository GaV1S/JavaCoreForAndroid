package Homework6;

public class Main {

    public static void main (String[] args) {
        Cat[] cats = new Cat[2];

        cats[0] = new Cat("Мурзик", 200, 37);
        cats[1] = new Cat("Нафаня", 150, 0);

        Dog[] dogs = new Dog[2];

        dogs[0] = new Dog("Рада", 500, 10);
        dogs[1] = new Dog("Мухтар", 150, 21);

        System.out.println(dogs[0].run(600));
        System.out.println(cats[1].swim(100));
    }
}
