package com.ly.studyspring.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by liuyu7 on 2019/1/29.
 */
@Retention(RetentionPolicy.RUNTIME)  // 注解会在class字节码文件中存在，在运行时可以通过反射获取到
@Target(ElementType.METHOD)
public @interface MyZhuJie {

    boolean value() default true;

    String btcpso() default "";
}
