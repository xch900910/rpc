package com.xch.rpc.loadbalance;

import com.ecwid.consul.v1.health.model.HealthService;

import java.util.List;
import java.util.Random;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 20:23
 */
public class RandomLoadBalancer implements LoadBalancer {
    @Override
    public HealthService select(List<HealthService> healthServices) {
        return healthServices.get(new Random().nextInt(healthServices.size()));
    }
}
