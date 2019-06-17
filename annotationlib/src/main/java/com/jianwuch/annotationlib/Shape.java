package com.jianwuch.annotationlib;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author jove.chen
 * @date 2019/6/11
 * 用于类
 * 存在于class中
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface Shape {
    Class type();
    String id();
}
