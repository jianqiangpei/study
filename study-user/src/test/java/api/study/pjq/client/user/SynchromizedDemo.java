package api.study.pjq.client.user;

/**
 * 任何对象都可以作为锁，那么锁存在哪里呢？
 *  锁存在对象头中。
 */
public class SynchromizedDemo {

    private static int value;


    /**
     * 当synchronized修饰的是方法的时候，内置锁是当前示例
     * @return
     */
    public synchronized int getNext(){
        return ++value;
    }


    /**
     * 当synchronized修饰的静态的方法的时候,内置锁是当前的class字节码对象
     * @return
     */
    public synchronized static int getPrev(){

        return --value;
    }


    public int getValue(){
        synchronized (this){
            return value;
        }
    }


}
