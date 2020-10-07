package org.lemon.netty.nio.threadlocal;

import java.util.IdentityHashMap;

/**
 * map的key比较的是内存地址，应用场景是什么，什么时候需要这种数据结构？？？
 *
 *
 *
 */
public class IdentityHashMapDemo {

    public static void main(String[] args) {
        IdentityHashMap<String ,Integer> identityHashMap = new IdentityHashMap<>();
        identityHashMap.put(new String("A"), 1);
        identityHashMap.put(new String("B"), 2);
        identityHashMap.put(new String("A"), 3);
        System.out.println(identityHashMap);
    }
}
