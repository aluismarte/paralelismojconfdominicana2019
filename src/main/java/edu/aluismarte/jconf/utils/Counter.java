package edu.aluismarte.jconf.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Controla los objetos contadores
 * <p>
 * Created by aluis on 10/28/18.
 */
public class Counter {

    private final Map<String, Freq> counter = new HashMap<>();

    public void printResults(final Long initTime) {
        long finishTime = System.currentTimeMillis();
        System.out.println("Init Time: " + initTime + " MS");
        System.out.println("Finish time: " + finishTime + " MS");
        System.out.println("Result time: " + (finishTime - initTime) + " MS");
        counter.forEach((integer, freq) -> System.out.println("El numero: " + freq.getNumber() + " se repitió: " + freq.getFreq()));
    }

    public void sumNumberMinimalSyncronize(String number) {
        Freq freq = counter.get(number);
        if (freq == null) {
            synchronized (counter) {
                counter.put(number, new Freq(number));
                freq = counter.get(number);
            }
        }
        freq.sumFreq();
    }

    public synchronized void sumNumberSyncronize(String number) {
        Freq freq = counter.get(number);
        if (freq == null) {
            counter.put(number, new Freq(number));
            freq = counter.get(number);
        }
        freq.sumFreq();
    }

}
