package org.lemon.netty.nio.tcp;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

public class TcpTestClientHandler extends SimpleChannelInboundHandler<ByteBuf> {

    private int count;

    /**
     * 循环推送100次消息，服务器端肯定会进行拆包粘包的，channelRead0每次读取到的内容都不是完整的，
     * 所以需要控制拆包和粘包的行为; 默认一个数据包的大小是多少??
     *
     *
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 1000; i++) {
            String message = "hello,server" + i + "------" + UUID.randomUUID().toString() + "end;";
            ByteBuf buffer = Unpooled.copiedBuffer(message, Charset.forName("utf-8"));
            ctx.writeAndFlush(buffer);
        }
    }

    /**
     *
     * 服务器返回了多次数据包，为什么这里只有一次打印？？？
     */
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, ByteBuf msg) throws Exception {
        byte[] buffer = new byte[msg.readableBytes()];
        msg.readBytes(buffer);
        String message = new String(buffer, Charset.forName("utf-8"));
        System.out.println("客户端接收到消息=" + message);
        System.out.println("客户端接收到消息数量=" + (++this.count));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getStackTrace());
    }
}
