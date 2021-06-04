package com.xch.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandler;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author: xiongchaohua
 * @Des :
 * @create: 2021-06-04 18:58
 **/
public class RpcServiceHandler extends SimpleChannelInboundHandler {
    public RpcServiceHandler() {
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {

    }
}
