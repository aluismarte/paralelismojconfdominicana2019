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

    public static final int PART_TO_LOAD = 50;
    public static final int ROWS_ON_DB = 500 * 1000;

    public static List<Integer> numberList() {
        List<Integer> numbers = new ArrayList<>();
        int NUMBER_TO_COUNT = 20;
        for (int i = 0; i < NUMBER_TO_COUNT; i++) {
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
