package com.xch.annotation;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@RpcComponentScan
@Inherited
public @interface EnableRpc {

}
