package org.lemon.netty.nio.buffer;

import java.nio.ByteBuffer;

/**
 * buffer需要理解的三个点
 *
 *
 */
public class NioByteBufferPutGet {

    public static void main(String[] args) {

        //创建一个Buffer
        ByteBuffer buffer = ByteBuffer.allocate(64);

        //类型化方式放入数据
        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);

        //取出
        buffer.flip();

        System.out.println();

        //存放的顺序和取出的顺序必须一致，否则会乱码，或者越界
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
    }
}
