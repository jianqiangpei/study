package api.study.pjq.client.user;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SynchronizedDemo3 {

    private Object object1 = new Object();
    private Object object2 = new Object();


    public void test1() throws InterruptedException {
        synchronized (object1){
            System.out.println("我拿到了object1的锁");
            TimeUnit.SECONDS.sleep(1);
            synchronized (object2){
                System.out.println("我执行完了");
            }
        }
    }

    public void test2() throws InterruptedException{
        synchronized (object2){
            System.out.println("我拿到了object2的锁");
            TimeUnit.SECONDS.sleep(1);
            synchronized (object1){
                System.out.println("我执行完了");
            }
        }
    }

    public static void main(String[] args) {
        SynchronizedDemo3 synchronizedDemo3 = new SynchronizedDemo3();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                synchronizedDemo3.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.submit(() -> {
            try {
                synchronizedDemo3.test2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executorService.shutdown();
    }
}
