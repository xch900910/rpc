package com.xch.rpc;

import com.xch.annotation.EnableRpc;
import com.xch.rpc.component.DemoServiceComponent;
import com.xch.rpc.demo.DemoService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author: xiongchaohua
 * @Des :
 * @create: 2021-06-04 18:14
 **/
public class ConsumerApplication {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        DemoService service = context.getBean("demoServiceComponent", DemoServiceComponent.class);
        String hello = service.sayHello("world");
        System.out.println("result :" + hello);
    }

    @Configuration
    @EnableRpc(scanBasePackages = "com.xch.rpc.component")
    @PropertySource("classpath:/rpc-consumer.properties")
    static class ConsumerConfiguration {

    }
}
