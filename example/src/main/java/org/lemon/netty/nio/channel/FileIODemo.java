package org.lemon.netty.nio.channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * 文件通道是阻塞式的，和socketIO的channel不同，是非阻塞式的；
 * <p>
 * 对于文件IO,最强大之处在于异步IO,它允许一个进程可以从操作系统请求一个或者多个Io操作，而不必等待这些操作的完成，
 * <p>
 * 发起请求的进程之后会收到它请求的IO操作已完成的通知
 * <p>
 * <p>
 * 上面的内容的理解，不确认是不是有问题
 * <p>
 * 网络IO是多路复用技术实现的，非阻塞的同步实现
 * <p>
 * 文件io是通过DMA从磁盘读取文件到内存，然后通过中断通知cpu去处理，是异步IO，进程发起获取数据，然后cpu异步通知回来，
 */
public class FileIODemo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("2.txt", "rw");
        FileChannel fileChannel = accessFile.getChannel();

    }
}
