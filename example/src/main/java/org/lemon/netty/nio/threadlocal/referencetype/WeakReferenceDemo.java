package org.lemon.netty.nio.threadlocal.referencetype;

import java.lang.ref.WeakReference;

/**
 * 无论内存是否充足，只要触发了gc，弱引用的对象就会被删除掉
 */
public class WeakReferenceDemo {

    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference<>(new M());
        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();
    }
}
