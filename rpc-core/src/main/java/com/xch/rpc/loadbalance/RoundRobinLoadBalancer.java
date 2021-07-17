package com.xch.rpc.loadbalance;

import com.ecwid.consul.v1.health.model.HealthService;

import java.util.List;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 20:24
 */
public class RoundRobinLoadBalancer implements LoadBalancer {
    private int index = 0;

    @Override
    public HealthService select(List<HealthService> healthServices) {
        if (index >= healthServices.size()) {
            index %= healthServices.size();
        }
        return healthServices.get(index++);
    }
}
