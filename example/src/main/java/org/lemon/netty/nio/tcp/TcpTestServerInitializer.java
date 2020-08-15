package org.lemon.netty.nio.tcp;


import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

public class TcpTestServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline channelPipeline = ch.pipeline();
//        channelPipeline.addLast(new TcpTestServerHandler());

        channelPipeline.addLast(new MyMessageDecoder());
        channelPipeline.addLast(new MyMessageEncoder());
        channelPipeline.addLast(new MyServerHandler());


    }
}
