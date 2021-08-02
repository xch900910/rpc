package com.xch.rpc;

import com.xch.rpc.annotation.Service;
import com.xch.rpc.demo.DemoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/7/28 6:40
 */
@Service
public class DemoServiceImpl implements DemoService {
    private final Logger logger = LoggerFactory.getLogger(DemoServiceImpl.class);
    @Override
    public String sayHello(String name) {
        logger.info(name + " say hello");
        return name + " say hello";
    }
}
