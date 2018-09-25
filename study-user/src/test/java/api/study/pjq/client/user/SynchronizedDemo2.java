package api.study.pjq.client.user;

public class SynchronizedDemo2 {

    public synchronized void test1(){
        System.out.println("我获得可这个实例的锁");
        test2();
        System.out.println("既然咱俩都要同一个锁，那么你可以执行么？答案是：yes");
    }

    public synchronized void test2(){
        System.out.println("我也要这个实例的锁");
    }

    public static void main(String[] args) {

        SynchronizedDemo2 synchronizedDemo2 = new SynchronizedDemo2();
        synchronizedDemo2.test1();
    }

}
