package org.lemon.netty.nio.threadlocal.referencetype;

import java.lang.ref.SoftReference;


/**
 * 软引用，当执行gc的时候，发现内存不足，就会删除软引用
 *
 * 软引用非常适合缓存使用
 *
 * 前提将Xmx20m 将堆空间设置为20m
 *
 * -XX:+PrintGCDetails 打印gc日志
 */
public class SoftReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference<>(new byte[1024 * 1024 * 10]);
        // m = null
        System.out.println(m.get());
        System.gc();

        Thread.sleep(500);
        System.out.println(m.get());

        // 再分配一个数组，heap装不下了，这个时候系统会垃圾回收，先回收一次，如果不够，会把软引用的删除
        // 这里有个问题就是创建一个15兆的数组也会报堆溢出，按理说上面的软引用删除掉，应该有20兆的空间，为什么连15兆都放不了
        // 下面设置成11兆就不会报错，并且上面的软引用也确实删除了
//        byte[] b = new byte[1024 * 1024 * 15];
        byte[] b = new byte[1024 * 1024 * 11];
        System.out.println(m.get());
    }

}
