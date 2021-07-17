package com.xch.rpc.registry;

import com.xch.rpc.util.ConsulUtil;

import java.net.InetSocketAddress;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 18:28
 */
public class ConsulServiceRegistry implements ServiceRegistry {
    @Override
    public void register(String serviceName, InetSocketAddress inetSocketAddress) {
        ConsulUtil.registerService(serviceName, inetSocketAddress);
    }
}
