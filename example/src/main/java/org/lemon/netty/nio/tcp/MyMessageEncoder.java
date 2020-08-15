package org.lemon.netty.nio.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * 编码器
 */
public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {

    /**
     * 暂时不清楚这个地方具体有什么作用？？？？
     *
     */
    @Override
    protected void encode(ChannelHandlerContext ctx, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder encode方法被调用");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
