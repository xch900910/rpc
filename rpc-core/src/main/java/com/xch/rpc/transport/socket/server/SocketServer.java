package com.xch.rpc.transport.socket.server;

import com.xch.rpc.factory.ThreadPoolFactory;
import com.xch.rpc.handler.RequestHandler;
import com.xch.rpc.registry.ConsulServiceRegistry;
import com.xch.rpc.serializer.CommonSerializer;
import com.xch.rpc.transport.AbstractRpcServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 21:08
 */
public class SocketServer extends AbstractRpcServer {
    private final ExecutorService threadPool;
    private final CommonSerializer serializer;
    private final RequestHandler requestHandler = new RequestHandler();

    public SocketServer(String host, int port) {
        this(host, port, DEFAULT_SERIALIZER);
    }

    public SocketServer(String host, int port, Integer serializer) {
        this.host = host;
        this.port = port;
        threadPool = ThreadPoolFactory.createDefaultThreadPool("socket-rpc-server");
        this.serializer = CommonSerializer.getByCode(serializer);
        this.serviceRegistry = new ConsulServiceRegistry();
        scanServices();

    }

    @Override
    public void start() {
        try (ServerSocket serverSocket = new ServerSocket();) {

        } catch (IOException e) {
            logger.error("服务器启动时有错误发生:", e);
        }

    }
}
