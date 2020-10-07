package org.lemon.netty.nio.threadlocal.referencetype;

public class Main {

    public static void main(String[] args) {
        int a = 10;
        new Main().func1(a);
        System.out.println(a);
    }

    public void func1(int a) {
        int b = 10;
        System.out.println((a + b));
        a = 11;
    }
}
