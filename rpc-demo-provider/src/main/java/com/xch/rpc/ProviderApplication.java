package com.xch.rpc;

import com.xch.annotation.EnableRpc;
import com.xch.annotation.RpcService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: xiongchaohua
 * @Des :
 * @create: 2021-06-04 18:14
 **/
public class ProviderApplication {
    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }

    @Configuration
    @EnableRpc(scanBasePackages = "rpc")
    @PropertySource("classpath:/rpc-provider.properties")
    static class ProviderConfiguration {

    }
}
