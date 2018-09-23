package api.study.pjq.client.user;

import org.assertj.core.util.DateUtil;

import java.util.Date;
import java.util.concurrent.*;
import java.util.stream.IntStream;

public class ThreadFour {

    public static void main(String[] args) {

        ExecutorService cachedExecutorService = Executors.newCachedThreadPool();
        IntStream.range(0 , 20).forEach(i ->
            cachedExecutorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("这是一个缓存线程池");
            })
        );

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        cachedExecutorService.shutdown();


        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        ScheduledFuture scheduledFuture1 = scheduledExecutorService.scheduleWithFixedDelay(() -> System.out.println("延迟一秒后每3秒执行一次") , 1 , 3, TimeUnit.SECONDS);
        ScheduledFuture scheduledFuture2 = scheduledExecutorService.schedule(() -> System.out.println("延迟一秒执行") , 1 , TimeUnit.SECONDS);
        ScheduledFuture scheduledFuture3 = scheduledExecutorService.scheduleAtFixedRate(() -> System.out.println("延迟一秒后每（3秒+上次执行任务的时间）执行一次") , 1 , 3, TimeUnit.SECONDS);

        try {
            System.out.println(scheduledFuture1.get());
            System.out.println(scheduledFuture2.get());
            System.out.println(scheduledFuture3.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        scheduledExecutorService.shutdown();

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        ExecutorService fixedExecutorService = Executors.newFixedThreadPool(5);
        IntStream.range(0 , 10).forEach(i ->
            fixedExecutorService.submit(() -> {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date().getTime() + "------" +i);
            })
        );
        fixedExecutorService.shutdown();

        ExecutorService SingleExecutorService = Executors.newSingleThreadExecutor();
        SingleExecutorService.submit(() -> System.out.println("我是单例线程1"));
        SingleExecutorService.submit(() -> System.out.println("我是单例线程2"));
        SingleExecutorService.submit(() -> System.out.println("我是单例线程3"));
        SingleExecutorService.submit(() -> System.out.println("我是单例线程4"));
        SingleExecutorService.shutdown();
    }

}
