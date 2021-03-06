package org.lemon.netty.nio.buffer;

import io.netty.buffer.ByteBuf;

import java.nio.ByteBuffer;

/**
 * 字节顺序，byteBuffer类有所不同，默认字节顺序总是byteOrder.BIG_ENDIAN, 无论系统固有的字节顺序是什么
 * <p>
 * java 的默认字节顺序是大端字节顺序，这允许类文件等以及串行化的对象可以在任何JVM中工作，
 */
public class ByteOrderDemo {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        System.out.println(byteBuffer.isDirect());
    }
}
