package com.xch.annotation;

import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(RpcComponentScanRegistrar.class)
public @interface RpcComponentScan {

    /**
     * 要扫描的包路径
     * @return
     */
    String[] value() default {};
}
