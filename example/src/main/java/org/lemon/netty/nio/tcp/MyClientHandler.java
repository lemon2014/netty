package org.lemon.netty.nio.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;


    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();
        System.out.println("客户端接收到的消息如下:");
        System.out.println("长度:" + len);
        System.out.println("内容:" + new String(content, Charset.forName("utf-8")));
        System.out.println("客户端接收消息的数量：" + (++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 5; i++) {
            String message = "今天跑半程马拉松";
            byte[] content = message.getBytes(Charset.forName("utf-8"));
            int length = content.length;

            //创建协议包
            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setContent(content);
            messageProtocol.setLen(length);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println(cause.getStackTrace());
    }
}
