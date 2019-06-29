package edu.aluismarte.jconf.tests;

import edu.aluismarte.jconf.domain.Work;
import edu.aluismarte.jconf.utils.Constants;
import edu.aluismarte.jconf.utils.Counter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aluis on 6/28/19.
 */
public class MultiThread {

    private static final Counter counter = new Counter();
    private static int poolSize = 5; // Always a multiply
    private static ExecutorService executorService = Executors.newFixedThreadPool(poolSize);

    public static void run() {
        long initTime = System.currentTimeMillis();
        List<Future<Boolean>> futures = new ArrayList<>();
        int part = DataLoader.countAll() / poolSize;
        // I divide the data in equal parts on each thread
        for (int i = 0; i < poolSize; i++) {
            int from = i * part;
            futures.add(addThreadMulti(executorService, from));
        }
        try {
            // Force to finish
            for (Future<Boolean> future : futures) {
                future.get();
            }
            System.out.println("Success!");
            counter.printResults(initTime);
        } catch (Exception ex) {
            System.out.println("Cant wait thread");
            ex.printStackTrace();
        }
        executorService.shutdown();
    }

    private static Future<Boolean> addThreadMulti(ExecutorService executorService, final int from) {
        return executorService.submit(() -> {
            try {
                for (Work work : DataLoader.loadByPart(from, Constants.PART_TO_LOAD)) {
                    counter.sumNumberSyncronize(work.getNumbers());
                }
            } catch (Exception ignored) {
                System.out.println("Revisar la excepción");
                return false;
            }
            return true;
        });
    }
}
