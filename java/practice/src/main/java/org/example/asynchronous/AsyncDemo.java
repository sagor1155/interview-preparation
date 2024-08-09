package org.example.asynchronous;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class AsyncDemo {
    public static void main(String[] args) {
//        runAsyncWithExecutorService();
//        runAsyncWithCompletableFuture();
//        pipeCompletableFuture();
        pipeAsyncCompletableFuture();

        try {
            Thread.sleep(1000);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }

    private static void pipeAsyncCompletableFuture() {
        Executor executor = Executors.newFixedThreadPool(4);
        CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(() -> {
                            System.out.println("supplyAsync: " + Thread.currentThread().getName());
                            return Arrays.asList(1, 2, 3, 4, 5, 6);
                        }, executor)
                        .thenApplyAsync(d -> {
                            System.out.println("thenApply: " + Thread.currentThread().getName());
                            return d.stream().map(elem -> elem*2).toList();
                        }, executor)
                        .thenAcceptAsync(d -> {
                            System.out.println("thenAccept: " + Thread.currentThread().getName());
                            System.out.println(d);
                        }, executor)
                        .thenRunAsync(() -> {
                            System.out.println("thenRun: " + Thread.currentThread().getName());
                            System.out.println("Completed");
                        }, executor);

    }

    private static void pipeCompletableFuture() {
        CompletableFuture<Void> future =
                CompletableFuture.supplyAsync(() -> Arrays.asList(1, 2, 3, 4, 5, 6))
                        .thenApply(d -> d.stream().map(elem -> elem*2).toList())
                        .thenAccept(System.out::println)
                        .thenRun(() -> System.out.println("Completed"));

    }

    private static void runAsyncWithCompletableFuture() {
        // CompletableFuture
        CompletableFuture<String> future = new CompletableFuture<>();
        future.whenComplete((res, ex) -> {
            if (ex == null) {
                System.out.println(res);
            }
        });
        future.complete("Something in coming");


        // runAsync
        CompletableFuture<Void> runAsyncFuture = CompletableFuture.runAsync(() -> {
            System.out.println("RunAsync: Running");
            System.out.println("RunAsync - Thread " + Thread.currentThread().getName());
        });

        runAsyncFuture.whenComplete((res, ex) -> {
            System.out.println("RunAsync: Completed");
        });


//        // supplyAsync
        CompletableFuture<Integer> supplyAsyncFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println("SupplyAsync: Running");
            System.out.println("SupplyAsync - Thread " + Thread.currentThread().getName());
            return 10;
        }, Executors.newFixedThreadPool(1)); // program doesn't return if used ExecutorService

        supplyAsyncFuture.whenComplete((res, ex) -> {
            System.out.println("SupplyAsync: Completed");
            System.out.println("SupplyAsync - Result: " + res);
        });


    }

    private static void runAsyncWithExecutorService() {
        try (ExecutorService executorService = Executors.newFixedThreadPool(2)) {
            Future<List<Integer>> future = executorService.submit(() -> {
                System.out.println("Current Thread: " + Thread.currentThread().getName());
                Thread.sleep(2000);
                return Arrays.asList(1, 2, 3, 4, 5);
            });

            try {
                List<Integer> list = future.get();
                System.out.println(list);
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
