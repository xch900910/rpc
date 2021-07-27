package com.xch.rpc;

import com.xch.rpc.demo.DemoService;
import com.xch.rpc.entity.RpcRequest;
import com.xch.rpc.transport.RpcClientProxy;
import com.xch.rpc.transport.socket.client.SocketClient;

import java.net.Socket;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/28 6:49
 */
public class SocketClientTest {
    public static void main(String[] args) {
        SocketClient socketClient = new SocketClient();
        RpcClientProxy proxy = new RpcClientProxy(socketClient);
        DemoService demoService = proxy.getProxy(DemoService.class);
        demoService.sayHello("raye");
        System.out.println("client send raye");
    }
}
