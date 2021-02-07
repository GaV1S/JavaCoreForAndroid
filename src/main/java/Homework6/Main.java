package Homework6;

public class Main {

    public static void main (String[] args) {
        Cat[] cats = new Cat[2];

        cats[0] = new Cat("Мурзик");
        cats[1] = new Cat("Нафаня");

        Dog[] dogs = new Dog[2];

        dogs[0] = new Dog("Рада");
        dogs[1] = new Dog("Мухтар");

        System.out.println(dogs[0].run(600));
        System.out.println(cats[1].swim(100));
    }
}
