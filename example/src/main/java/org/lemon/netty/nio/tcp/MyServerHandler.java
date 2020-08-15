package org.lemon.netty.nio.tcp;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;
import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<MessageProtocol> {

    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.out.println("服务器接收到的消息如下");
        System.out.println("长度=" + len);
        System.out.println("内容=" + new String(content, Charset.forName("utf-8")));
        System.out.println("服务器接收到消息包数量" + (++this.count));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

        //回复消息
        String responseStr = UUID.randomUUID().toString();
        int responseLen = responseStr.getBytes("utf-8").length;
        byte[] responseContent = responseStr.getBytes("utf-8");

        //构建一个协议包
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(responseLen);
        messageProtocol.setContent(responseContent);
        ctx.writeAndFlush(messageProtocol);
    }
}
