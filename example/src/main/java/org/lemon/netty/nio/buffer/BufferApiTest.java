package org.lemon.netty.nio.buffer;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;

public class BufferApiTest {

    public static void main(String[] args) {

        /**
         * arrayOffset()方法的作用
         */
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);
        System.out.println(byteBuffer.arrayOffset()); //返回缓存区数据在数组中存储的开始位置的偏移量, 通过上面的方式的创建的缓冲区，offset始终都是返回0
        byteBuffer.put((byte)'a');
        byteBuffer.flip();
        System.out.println(byteBuffer.arrayOffset());

        byte[] bytes = new byte[100];
        ByteBuffer byteBuffer1 = ByteBuffer.wrap(bytes, 20, 30); //offset = 0，pos = 20， limit = 50，cap = 100
        System.out.println(byteBuffer1.arrayOffset());

        //只有在缓冲去切分的情况下才能回到offset可能不为0, 下面的逻辑相当于把数组的3到5的位置给sliceBuffer，用于它的存储，offset估计也就是这个地方有用

        /**
         * 这里不做重点，知道就可以了，主要是pos、lim、cap三个属性比较重要
         */
        CharBuffer buffer = CharBuffer.allocate(10);
        buffer.position(3).limit(5);
        CharBuffer sliceBuffer = buffer.slice();
        System.out.println(sliceBuffer.arrayOffset());



        //复制操作
        /**
         * duplicate会复制已buffer出来，并且属性和之前的一样，并且他们公用数组对象，所以对原本的buffer或者是复制出来的buffer的修改，
         * 都会反映到另外的一个buffer上面，但是仅仅是数组对象会有改变，其他的属性不会改变
         *
         */
        CharBuffer charBuffer = CharBuffer.allocate(8);
        CharBuffer dupeBuffer = charBuffer.duplicate();
        charBuffer.position(3).limit(6).mark().position(5);
        dupeBuffer.put('H');
        charBuffer.clear();


        System.out.println(ByteOrder.nativeOrder().toString());

    }
}
