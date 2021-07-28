package com.xch.rpc.util;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.QueryParams;
import com.ecwid.consul.v1.Response;
import com.ecwid.consul.v1.agent.model.NewService;
import com.ecwid.consul.v1.health.model.HealthService;

import java.net.InetSocketAddress;
import java.util.*;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 18:29
 */
public class ConsulUtil {
    private static final Set<String> serviceNames = new HashSet<>();
    private static InetSocketAddress address;
    private static ConsulClient client;

    private static final String SERVER_HOST = "127.0.0.1";
    private static final int SERVER_PORT = 8500;

    static {
        client = new ConsulClient(SERVER_HOST, SERVER_PORT);
    }

    public static void registerService(String serviceName, InetSocketAddress address) {
        NewService newService = new NewService();
        newService.setId(serviceName);
        newService.setName(serviceName);
        newService.setTags(Arrays.asList("EU-West", "EU-East"));
        newService.setPort(SERVER_PORT);

        NewService.Check serviceCheck = new NewService.Check();
        serviceCheck.setHttp("http://127.0.0.1:8500/health");
        serviceCheck.setInterval("10s");
        newService.setCheck(serviceCheck);
        client.agentServiceRegister(newService);
    }

    public static List<HealthService> findHealthService(String serviceName) {
        Response<List<HealthService>> healthyServices = client.getHealthServices(serviceName,
                true, QueryParams.DEFAULT);
        return healthyServices.getValue();
    }

}
