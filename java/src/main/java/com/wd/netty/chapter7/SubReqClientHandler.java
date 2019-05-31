package com.wd.netty.chapter7;

import io.netty.channel.ChannelHandlerAdapter;
import io.netty.channel.ChannelHandlerContext;

public class SubReqClientHandler extends ChannelHandlerAdapter {

//	@Override
	public void channelActive(ChannelHandlerContext ctx)
			throws Exception {
		for(int i=0;i<10;i++){
			ctx.write(subReq(i));
		}
		ctx.flush();
	}

	private SubscribeReq subReq(int i) {
		SubscribeReq req = new SubscribeReq();
		req.setAddress("XX市XX街道XX小区");
		req.setPhoneNumber("135XXXXXXXX");
		req.setProductName("Netty 权威指南");
		req.setSubReqId(i);
		req.setUserName("Lilinfeng");
		return req;
	}

	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
			throws Exception {
		cause.printStackTrace();
		ctx.close();
	}
	
//	@Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("Receive server response : ["+msg+"]");
    }
	
//	@Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

}
