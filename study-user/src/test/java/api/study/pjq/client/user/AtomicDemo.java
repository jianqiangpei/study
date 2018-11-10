package api.study.pjq.client.user;

import lombok.*;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.*;
import java.util.stream.IntStream;

public class AtomicDemo {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);
    private static AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(new int [] {1,2,3});

    public static void main(String[] args) {

        for (int i = 0 ; i<5 ; i++){
            new Thread(() -> {
                int k = 0;
                while (k < 10){
                    try {
                        TimeUnit.SECONDS.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(atomicInteger.incrementAndGet());      //++i
                    System.out.println(atomicInteger.getAndIncrement());      //i++
                    System.out.println(atomicInteger.decrementAndGet());      //--i
                    System.out.println(atomicInteger.getAndDecrement());        //i--

                    atomicBoolean.compareAndSet(false, true);       //比较+赋值 为一个原子性的操作，中间不会有可乘之机
                    System.out.println(Thread.currentThread().getName() + "----" + atomicBoolean.get());

                    atomicIntegerArray.addAndGet(4 , 6);
//
                    User user1 = new User();
                    user1.setUserId(1);
                    AtomicReference<User> userAtomicReference = new AtomicReference<>(user1);
                    User user2 = new User();
                    user2.setUserId(2);
                    userAtomicReference.compareAndSet(user2 , user2);   //先比较，再赋值。比较为true后才赋值
                    System.out.println(userAtomicReference.get().userId);
                    k++;

                }
            }).start();
        }
    }

    public native void test();

    @Data
    public static class User{
        public volatile int userId;
    }
}


//    System.out.println(new Date().getTime());
//        for(int i = 0 ; i < 10000 ; i++){
//
//    }
//        System.out.println(new Date().getTime());
//
//        System.out.println(new Date().getTime());
//    ExecutorService executorService = Executors.newFixedThreadPool(1);
//        executorService.submit(() -> {
//        while (i++ < 10000){
//
//        }
//        System.out.println(new Date().getTime());
//    });
//        executorService.shutdown();


