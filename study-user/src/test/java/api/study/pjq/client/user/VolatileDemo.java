package api.study.pjq.client.user;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public  class VolatileDemo {

    private volatile int i = 0;


    public void test1(){
        if(i % 2 == 0){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        i++;
        System.out.println(Thread.currentThread().getName() + "---"+getI());
    }

    public int getI(){
        return i;
    }

    public static void main(String[] args) {

        VolatileDemo volatileDemo = new VolatileDemo();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());
        executorService.submit(() -> volatileDemo.test1());

        executorService.shutdown();
    }

}
