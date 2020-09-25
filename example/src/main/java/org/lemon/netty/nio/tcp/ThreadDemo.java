package org.lemon.netty.nio.tcp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println("线程内容被执行！");
            }
        });

    }
}
