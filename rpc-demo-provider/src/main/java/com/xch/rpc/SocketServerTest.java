package com.xch.rpc;

import com.xch.rpc.annotation.ServiceScan;
import com.xch.rpc.transport.socket.server.SocketServer;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/28 6:42
 */
@ServiceScan
public class SocketServerTest {
    public static void main(String[] args) {
        SocketServer socketServer = new SocketServer("127.0.0.1", 9999);
        socketServer.start();
    }
}
