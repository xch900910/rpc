package com.xch.rpc.registry;

import com.ecwid.consul.v1.health.model.HealthService;
import com.xch.rpc.enumeration.RpcError;
import com.xch.rpc.exception.RpcException;
import com.xch.rpc.loadbalance.LoadBalancer;
import com.xch.rpc.util.ConsulUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.util.List;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 18:27
 */
public class ConsulServiceDiscovery implements ServiceDiscovery {
    private static final Logger logger = LoggerFactory.getLogger(ConsulServiceDiscovery.class);

    private final LoadBalancer loadBalancer;

    public ConsulServiceDiscovery(LoadBalancer loadBalancer) {
        this.loadBalancer = loadBalancer;
    }

    @Override
    public InetSocketAddress lookupService(String serviceName) {
        List<HealthService> healthServices = ConsulUtil.findHealthService(serviceName);
        if (healthServices.size() == 0) {
            logger.error("找不到对应的服务: " + serviceName);
            throw new RpcException(RpcError.SERVICE_NOT_FOUND);
        }
        HealthService healthService = loadBalancer.select(healthServices);
        return new InetSocketAddress(healthService.getService().getAddress(), healthService.getService().getPort());
    }
}
