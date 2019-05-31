package com.wd.netty.nettyActualCombat.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

public class EchoServer {

    private final int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] arg0) throws InterruptedException {
//        if (arg0.length != 1) {
//            System.err.println("Usage:"+EchoServer.class.getSimpleName()+"<port>");
//        }
        int port = 20000;
        new EchoServer(port).start();
    }

    public void start() throws InterruptedException {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        //创建eventLookGroup
        EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        try {
            //创建ServerBootstrap
            ServerBootstrap b = new ServerBootstrap();
            b.group(eventLoopGroup)
                    .channel(NioServerSocketChannel.class)//指定所使用的nio传输channel
                    .localAddress(new InetSocketAddress(port))//使用指定的端口设置套接字的地址
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //添加一个echoserverhandler到子channel的ChannelPipeline
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
            });
            //异步绑定服务器，调用sync方法阻塞等待直到绑定完成
            ChannelFuture f = b.bind().sync();
            //获取channel的closefuture，并且阻塞当前线程知道它完成
            f.channel().closeFuture().sync();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //关闭eventLoopGroup并释放所有资源
            eventLoopGroup.shutdownGracefully().sync();
        }
    }
}
