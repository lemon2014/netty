package org.lemon.netty.nio.threadlocal.referencetype;

public class M {

    /**
     * 垃圾收集的时候会调用该方法
     */
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
