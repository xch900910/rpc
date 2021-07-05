package com.xch.annotation;

import java.lang.annotation.*;

/**
 * @author: xiongchaohua
 * @Des : 服务提供注解
 * @create: 2021-06-04 18:40
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Inherited
public @interface RpcService {

    /**
     * 提供服务类
     */
    Class<?> interfaceClass() default void.class;

    /**
     * 服务名称
     */
    String interfaceName() default "";

    /**
     * 服务版本号
     */
    String version() default "";

    /**
     * Customized parameter key-value pair, for example: {key1, value1, key2, value2}
     */
    String[] parameters() default {};
}
