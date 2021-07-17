package com.xch.rpc.loadbalance;

import com.ecwid.consul.v1.health.model.HealthService;

import java.util.List;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/17 19:50
 */
public interface LoadBalancer {
    HealthService select(List<HealthService> healthServices);
}
