package com.example.myapplication;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标记切点
 *   @interface 代表就是注解
 *   @Target 代表你放在那个位置  ElementType.TYPE 放在类上 ElementType.METHOD放在方法上  ElementType.FIELD放在属性上
 *   @Retention RetentionPolicy.RUNTIME 代表运行时 RetentionPolicy.CLASS代表编译时  RetentionPolicy.SOURCE代表资源
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CheckNet {
}
