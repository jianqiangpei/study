package api.study.pjq.client.user;

public class ThreadTwo implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {

        new Thread(new ThreadTwo()).start();
    }
}
