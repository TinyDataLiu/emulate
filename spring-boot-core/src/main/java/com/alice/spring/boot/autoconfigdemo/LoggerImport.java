package com.alice.spring.boot.autoconfigdemo;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.util.StringUtils;

/**
 * 动态实现注入bean 的第二种方法
 *
 * @author liuchun
 * @date 2020/02/28  10:34
 */
public class LoggerImport implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        RootBeanDefinition definition = new RootBeanDefinition(LoggerService.class);
        registry.registerBeanDefinition(StringUtils.uncapitalize(LoggerService.class.getName()), definition);
    }
}
