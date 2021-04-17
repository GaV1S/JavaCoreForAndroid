package Homework11;

import Homework11.fruit.Apple;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        Box<Apple> appleBox1 = new Box(5, new Apple(), new Apple(), new Apple());
        Box<Apple> appleBox2 = new Box(2);

        System.out.println(appleBox1.getWeight());
        appleBox1.transferFruitsToAnotherBox(appleBox2);
        System.out.println(appleBox1.getWeight());
        System.out.println(appleBox2.getWeight());

        var appleBoxes = new ArrayList<Box<Apple>>();
        for (Box<Apple> i : appleBoxes){

        }

    }

    public static <T> List<T> arrayToList(T[] array){
        return Arrays.asList(array);
    }

    public static <T> boolean swapArrayElements(T[] array, int firstElementIndex, int secondElementIndex) {
        if (firstElementIndex < 0 || firstElementIndex >= array.length || secondElementIndex <0 || secondElementIndex >= array.length) {
            System.err.println("Неверные данные для замены. Проверьте наличие элементов массива и верных индексов заменяемых элементов");
            return false;
        }
        T buffer = array[firstElementIndex];
        array[firstElementIndex] = array[secondElementIndex];
        array[secondElementIndex] = buffer;
        return true;
    }
}
