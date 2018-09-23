package api.study.pjq.client.user;

public class ThreadOne extends Thread{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }


    public static void main(String[] args) {
        new ThreadOne().start();
    }

}
