package api.study.pjq.client.user;

public class JVMDemo1 {


    public void test(){

        String s1 = "abc";
        String s2 = "abc";
        String s = new String("abc");

        System.out.println(s.intern() == s2);

    }

    public static void main(String[] args) {
        JVMDemo1 jvmDemo1 = new JVMDemo1();
        jvmDemo1.test();
    }

}
