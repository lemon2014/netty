package org.lemon.netty.nio.threadlocal;

import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;

public class FastThreadLocalDemo {
    private static FastThreadLocal<String> ftl = new FastThreadLocal<>();//这里只是初始化index的值

    public static void main(String[] args) {
        new FastThreadLocalThread(() -> {
            ftl.set("name");
            System.out.println(ftl.get());
        }).start();
    }
}
