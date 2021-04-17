package Homework7;

public class Main {

    public static void main (String[] args) {
        Cat[] cats = new Cat[2];
        Plate plate = new Plate(20);

        cats[0] = new Cat("Мурзик",20);
        cats[1] = new Cat("Нафаня",10);

        plate.addFood(50);

        cats[1].eat(plate);

        plate.info();

        System.out.println(cats[1].toString());
    }
}
