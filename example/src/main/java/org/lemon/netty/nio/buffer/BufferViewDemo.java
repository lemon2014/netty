package org.lemon.netty.nio.buffer;

import io.netty.util.CharsetUtil;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 视图缓冲区
 * 通过字节缓冲区创建的视图缓冲区，底层公用的数组，只是方便读取，例如字节缓冲区里面存的内容，原本就要是char字符，
 */
public class BufferViewDemo {

    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.allocate(7);
        CharBuffer charBuffer = byteBuffer.asCharBuffer();
        String str = "测试";
        byteBuffer.put(str.getBytes("GBK"));
        char c = charBuffer.get();
        System.out.println(c);
    }
}
