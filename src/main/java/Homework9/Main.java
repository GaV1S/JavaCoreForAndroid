package Homework9;

public class Main {

    public static void main(String[] args) {
        String[][] array = {{"36", "46", "72", "10"}, {"11", "2", "0", "100"}, {"1", "2", "3", "4"}, {"0", "0", "0", "0"}};  //Массив рабочий
//        String[][] array = {{"36", "46", "72", "10"}, {"11", "2", "0", "100"}, {"1", "2", "3", "4"}, {"0", "0", "0", "0"}, {"0", "0", "0", "0"}};  //Массив с неправильной размерностью
//        String[][] array = {{"36", "46", "72", "10"}, {"11", "2", "0", "100"}, {"1", "2", "D", "4"}, {"0", "0", "0", "0"}};  //Массив с символом
        System.out.println("Сумма чисел массива: " + sumStringArray4x4(array));
    }

    public static int sumStringArray4x4(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException("Недопустимый размер массива");
        }
        int sumOfArrayElements = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                try {
                    sumOfArrayElements += Integer.parseInt(array[i][j]);
                } catch (RuntimeException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumOfArrayElements;
    }
}

class MyArraySizeException extends RuntimeException {
    public MyArraySizeException(String exceptionString) {
        super(exceptionString);
    }
}

class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j) {
        super("Ошибка в типе данных массива в " + (++i) + "-й строке, в " + (++j) + "-м столбце");
    }
}
