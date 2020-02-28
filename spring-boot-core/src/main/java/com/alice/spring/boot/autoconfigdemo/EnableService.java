package com.alice.spring.boot.autoconfigdemo;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 动态注入bean
 *
 * @author liuchun
 * @date 2020/02/28  9:50
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({LoggerImport.class})
public @interface EnableService {
    Class<?>[] exclude() default {};

    String[] excludeName() default {};
}
