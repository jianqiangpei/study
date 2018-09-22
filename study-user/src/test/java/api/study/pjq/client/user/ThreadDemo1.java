package api.study.pjq.client.user;

import org.assertj.core.util.DateUtil;

import java.util.concurrent.TimeUnit;

public class ThreadDemo1 extends Thread{

    private final Integer i;

    public ThreadDemo1(Integer i){
        super();
        this.i = i;
    }


    @Override
    public void run() {
        int i = 0;
        while (++i < this.i){
            System.out.println("线程执行了"+i);
        }

    }

    public static void main(String[] args) {

        ThreadDemo1 demo1 = new ThreadDemo1(10000000);
        demo1.setDaemon(false);
        demo1.start();

        try {
            TimeUnit.MILLISECONDS.sleep(300L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("over");
    }

}
