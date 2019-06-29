package edu.aluismarte.jconf.utils;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by aluis on 6/28/19.
 */
public class Constants {

    private static int numbersCount = 9;

    public static List<Integer> numberList() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < numbersCount; i++) {
            numbers.add(i + 1);
        }
        return numbers;
    }

    public static void shuffle(@NotNull List<Integer> ar) {
        Random rnd = ThreadLocalRandom.current();
        for (int i = ar.size() - 1; i > 0; i--) {
            int index = rnd.nextInt(i + 1);
            int a = ar.get(index);
            ar.set(index, ar.get(i));
            ar.set(i, a);
        }
    }
}
