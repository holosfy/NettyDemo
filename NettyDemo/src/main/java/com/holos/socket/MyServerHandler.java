package com.holos.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String>{

    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {

        //接收数据并打印
        System.out.println(ctx.channel().remoteAddress() + ", "+ msg);

        ctx.writeAndFlush("from server + " + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        //如果出现异常则关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
