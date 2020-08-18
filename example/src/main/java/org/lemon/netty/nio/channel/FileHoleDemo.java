package org.lemon.netty.nio.channel;

import io.netty.util.CharsetUtil;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

/**
 * 文件空洞, FileChannel不像缓冲区Buffer，初始以后就不能改变大小了，fileChannel能扩容； 例如空白文件写入'test'字符，position的值为4，
 * 表示后续写文件的时候，从索引值为4的位置上面开始写值，但是可以通过channel.position设置position的值，现在把position的值设置成100，然后
 * 写文件的时候就会从100开始写，从4到100之间就会形成空洞，是无法写内容的，
 */
public class FileHoleDemo {

    public static void main(String[] args) throws Exception {
        File temp = File.createTempFile("holy", null);
        RandomAccessFile file = new RandomAccessFile(temp, "rw");
        FileChannel channel = file.getChannel();

        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        String str = "test";
        byteBuffer.put(str.getBytes(CharsetUtil.UTF_8));
        byteBuffer.flip();
        int result = channel.write(byteBuffer);
        String path = temp.getPath();

        channel.position(200);

        byteBuffer.clear();
        byteBuffer.put(str.getBytes(CharsetUtil.UTF_8));
        byteBuffer.flip();
        result = channel.write(byteBuffer);
        System.out.println(file.length());
        channel.close();
        file.close();

        //这里必须是通过上面的close把内容刷新到磁盘上，下面才能通过buffer获取到内容，否则下面的readLength的值始终返回-1
        RandomAccessFile randomAccessFile = new RandomAccessFile(path, "rw");
        FileChannel fileChannel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(100);
        while (true) {
            byteBuffer1.clear();
            int readLength = fileChannel.read(byteBuffer1);
            System.out.println("readLength:" + readLength);
            if (readLength <= 0) {
                break;
            }
            byteBuffer1.flip();
            Charset charset = Charset.forName("UTF-8");
            System.out.println("读取内容:" + charset.decode(byteBuffer1).toString());
        }


    }


}
