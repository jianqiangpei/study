package api.study.pjq.client.user;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class ThreadThree implements Callable<Integer> {


    @Override
    public Integer call() throws Exception {

        Random random = new Random(100);
        return random.nextInt();
    }

    public static void main(String[] args) throws Exception{

        ThreadThree threadThree = new ThreadThree();

        FutureTask<Integer> futureTask = new FutureTask<>(threadThree);

        Thread thread = new Thread(futureTask);
        thread.start();

        System.out.println("主线程over1");
        Integer result = futureTask.get();
        System.out.println(result);
        System.out.println("主线程over2");

    }
}
