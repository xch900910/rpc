package com.xch.rpc;

import com.xch.rpc.annotation.Service;
import com.xch.rpc.demo.DemoService;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/28 6:40
 */
@Service
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return name + " say hello";
    }
}
