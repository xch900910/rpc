package com.xch.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

/**
 * @author xch900910
 * @version 1.0
 * @date 2021/6/5 19:31
 */
public class RpcBootstrapApplicationListener implements ApplicationListener, ApplicationContextAware, Ordered {
    public static final String BEAN_NAME = "rpcBootstrapApplicationListener";

    @Override
    public int getOrder() {
        return 0;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {

    }
}
