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

    public MonoThread() {
    }

    public void runLoadAllData() {
        long initTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Boolean> mono = executorService.submit(() -> {
            try {
                for (Work work : DataLoader.loadAll()) {
                    counter.sumNumberSyncronize(work.getNumbers());
                }
            } catch (Exception ignored) {
                System.out.println("Revisar la excepción");
                return false;
            }
            return true;
        });
        try {
            if (mono.get()) {
                System.out.println("Exito!");
                counter.printResults(initTime);
            } else {
                System.out.println("Error al calcular");
            }
        } catch (Exception ignored) {
            System.out.println("No pude esperar el hilo");
        }
        executorService.shutdown();
    }

}
