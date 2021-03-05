package Homework12;

import java.util.Arrays;

public class Main {
    static final int SIZE = 10000000;
    static final int HALF = SIZE / 2;
    static float[] array = new float[SIZE];

    public static void main(String[] args) {
        createAndFillArray();
        createAndFillArrayWithThreads();
    }

    public static void createAndFillArray() {
        Arrays.fill(array, 1);
        long begin  = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            array[i] = (float)(array[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
        }
        System.out.println("Method 1: " + (System.currentTimeMillis() - begin ));
    }

    public static void createAndFillArrayWithThreads() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1);
        long begin  = System.currentTimeMillis();
        float[] array1 = new float[HALF];
        float[] array2 = new float[HALF];
        System.arraycopy(array, 0, array1, 0, HALF);
        System.arraycopy(array, HALF, array2, 0, HALF);
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                array1[i] = (float)(array1[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < HALF; i++) {
                array2[i] = (float)(array2[i] * Math.sin(0.2f + (float) i / 5) * Math.cos(0.2f + (float) i / 5) * Math.cos(0.4f + (float) i / 2));
            }
        });
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
        System.arraycopy(array1, 0, array, 0, HALF);
        System.arraycopy(array2, 0, array, HALF, HALF);
        System.out.println("Method 2: " + (System.currentTimeMillis() - begin ));
    }
}

