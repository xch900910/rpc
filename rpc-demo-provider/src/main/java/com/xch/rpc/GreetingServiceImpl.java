package com.xch.rpc;

import com.xch.rpc.annotation.Service;
import com.xch.rpc.demo.GreetingService;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/28 6:41
 */
@Service
public class GreetingServiceImpl implements GreetingService {
    @Override
    public String hello() {
        return "hello";
    }
}
