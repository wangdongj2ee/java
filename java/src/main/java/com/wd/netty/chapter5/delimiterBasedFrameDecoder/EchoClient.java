package com.wd.netty.chapter5.delimiterBasedFrameDecoder;

import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

public class EchoClient {

	public void connect(int port, String host) {
		EventLoopGroup group = new NioEventLoopGroup();
		try{
			Bootstrap b = new Bootstrap();
			b.group(group).channel(NioSocketChannel.class)
					.option(ChannelOption.TCP_NODELAY, true)
					.handler(new ChannelInitializer<Channel>() {
						@Override
						protected void initChannel(Channel ch) throws Exception {
							// TODO Auto-generated method stub
							ByteBuf delimiter = Unpooled.copiedBuffer("$_"
									.getBytes());
							ch.pipeline()
									.addLast(
											new DelimiterBasedFrameDecoder(1024,
													delimiter));
							ch.pipeline().addLast(new StringDecoder());
							ch.pipeline().addLast(new EchoClientHandler());
						}
					});
			ChannelFuture f = b.connect(host,port).sync();
			f.channel().closeFuture().sync();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			group.shutdownGracefully();
		}
	}
	
	public static void main(String[] args) {
		new EchoClient().connect(8080,"127.0.0.1");
	}
	
}
