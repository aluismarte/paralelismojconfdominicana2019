package edu.aluismarte.jconf.tests;

import edu.aluismarte.jconf.domain.Work;
import edu.aluismarte.jconf.utils.Counter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by aluis on 6/28/19.
 */
public class MonoThread {

    private static final Counter counter = new Counter();

    public static void run() {
        long initTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Boolean> mono = executorService.submit(() -> {
            try {
                for (Work work : DataLoader.loadAll()) {
                    counter.sumNumberSyncronize(work.getNumbers());
                }
            } catch (Exception ex) {
                System.out.println("Error!");
                ex.printStackTrace();
                return false;
            }
            return true;
        });
        try {
            // Force to finish
            if (mono.get()) {
                System.out.println("Success!");
                counter.printResults(initTime);
            } else {
                System.out.println("Error");
            }
        } catch (Exception ex) {
            System.out.println("Cant wait thread");
            ex.printStackTrace();
        }
        executorService.shutdown();
    }

}
