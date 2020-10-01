package org.lemon.netty.nio.threadlocal;

public class MyThreadLocalDemo2 {

    //这是主线程
    private static ThreadLocal<String> name = new ThreadLocal<>();
    private static InheritableThreadLocal<String> tl = new InheritableThreadLocal<>();

    public static void main(String[] args) {

        new Thread(() -> {
            name.set("name");
            tl.set("english");

            new Thread(() -> {
                System.out.println(name.get());//null
                System.out.println(tl.get());//english
                tl.set("name change by thread2");

                new Thread(() -> {
                    System.out.println(name.get());//null
                    System.out.println(tl.get());//name change by thread2

                }, "Thread--3").start();
            }, "Thread--2").start();
        }, "Thread--1").start();
    }


}
