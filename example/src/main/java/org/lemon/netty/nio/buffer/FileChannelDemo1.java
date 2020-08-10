package org.lemon.netty.nio.buffer;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo1 {

    public static void main(String[] args) throws Exception{
        String str = "测试文件的写入";
        FileOutputStream fileOutputStream = new FileOutputStream("file01.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

        //将str写入buffer
        byteBuffer.put(str.getBytes());

        //反转后将buffer的内容读入到文件中
        byteBuffer.flip();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();
    }
}
