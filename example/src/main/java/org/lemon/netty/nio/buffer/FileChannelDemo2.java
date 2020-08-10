package org.lemon.netty.nio.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 当文件比较大的时候要怎么处理？？？
 */
public class FileChannelDemo2 {

    public static void main(String[] args) throws Exception {

        File file = new File("file01.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        FileChannel fileChannel = fileInputStream.getChannel();

        // 构建一个buffer,将channel里面的内容读到buffer中
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        // 这里如果使用循环去读取文件内容，会有乱码，不使用循环读取内容，当文件比较大的时候要怎么处理？
        while (true) {
            byteBuffer.clear();
            int readByte = fileChannel.read(byteBuffer);
            byteBuffer.flip();

            //将buffer转化成string
            Charset charset = Charset.forName("utf-8");
            System.out.println(charset.decode(byteBuffer).toString());
            if (readByte < 1024) {
                break;
            }
        }
    }
}
