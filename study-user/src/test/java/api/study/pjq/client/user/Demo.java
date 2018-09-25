package api.study.pjq.client.user;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Demo {


    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        IntStream.range(1 , 20).forEach(i ->{
            executorService.submit(() -> {
                System.out.println(Singleton1.singleton1());
            });
        });
        executorService.shutdown();

    }
}
