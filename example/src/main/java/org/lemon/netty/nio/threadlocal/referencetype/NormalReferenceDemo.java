package org.lemon.netty.nio.threadlocal.referencetype;

import java.io.IOException;

public class NormalReferenceDemo {

    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();//由于gc的不确认性，所有这里显示的调用gc

        // 由于gc是非main线程执行，main线程结束可能gc线程还没开始执行，所以这里调用read等待，等待gc线程的执行
        System.in.read();
    }

}
