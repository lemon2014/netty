package org.lemon.netty.nio.threadlocal;

public class MyThreadLocalDemo {
    private static ThreadLocal<String> name = new ThreadLocal<>();
    private static String str = "";

    public static void main(String[] args) {
        new Thread(() -> {
            name.set("english");
            str = "hello world";
        }).start();

        new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name.get());
            System.out.println(str);
        }).start();
    }
}
