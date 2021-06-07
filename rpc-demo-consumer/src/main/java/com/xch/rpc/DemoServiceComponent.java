
package com.xch.rpc;

import com.xch.annotation.RpcReference;
import com.xch.rpc.demo.DemoService;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class DemoServiceComponent implements DemoService {
    @RpcReference
    private DemoService demoService;

    @Override
    public String sayHello(String name) {
        return demoService.sayHello(name);
    }

    @Override
    public CompletableFuture<String> sayHelloAsync(String name) {
        return null;
    }
}
