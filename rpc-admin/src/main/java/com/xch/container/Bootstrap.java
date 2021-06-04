package com.xch.container;

import com.xch.handler.RpcServiceHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: xiongchaohua
 * @Des :
 * @create: 2021-06-04 18:18
 **/
@Component
public class Bootstrap implements InitializingBean {
    @Value("${container.port}")
    private int containerPort;
    /**
     * 存放 服务名 与 服务对象 之间的映射关系
     */
    private Map<String, Object> registerServiceMap = new HashMap<>();

    @Override
    public void afterPropertiesSet() throws Exception {
        initContainer();
    }

    private void initContainer() throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel channel) throws Exception {
                        ChannelPipeline pipeline = channel.pipeline();
                        pipeline.addLast(new RpcServiceHandler());
                    }
                });

        bootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        bootstrap.childOption(ChannelOption.SO_KEEPALIVE, true);


        try {
            // 启动 RPC 服务器
            ChannelFuture future = bootstrap.bind(containerPort).sync();

            // 注册 RPC 服务地址
            registerService(registerServiceMap);
            // 关闭 RPC 服务器
            future.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }

    }

    private void registerService(Map<String, Object> registerServiceMap) {

    }
}
