package Homework10.First;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        final int COUNT_WORD = 15;
        final int TYPE_OF_SYMBOLS = 5;
        final int MAX_CHAR_IN_WORD = 2;
        final int MIN_CHAR_IN_WORD = 2;

        Random random = new Random();

        List<String> list = new ArrayList<>();
        List<String> listUnique;
        Map<String, Integer> frequencyElement = new HashMap<>();

        for (int i = 0; i < COUNT_WORD; i++) {
            char[] word = new char[random.nextInt(MAX_CHAR_IN_WORD - MIN_CHAR_IN_WORD + 1) + MIN_CHAR_IN_WORD];
            for (int j = 0; j < word.length; j++) {
                word[j] = (char) ('a' + random.nextInt(TYPE_OF_SYMBOLS));
            }
            list.add(new String(word));
        }
        System.out.println(list);

        Set<String> unique = new HashSet<>(list);
        for (String key : unique) {
            frequencyElement.put(key, Collections.frequency(list, key));
        }
        System.out.println(frequencyElement);

        listUnique = new ArrayList<>(new HashSet<>(list));
        System.out.println(listUnique);
    }
}