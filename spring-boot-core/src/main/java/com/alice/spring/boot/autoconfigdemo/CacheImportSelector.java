package com.alice.spring.boot.autoconfigdemo;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;
import org.springframework.core.type.MethodMetadata;

import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * @author liuchun
 * @date 2020/02/28  9:49
 */
public class CacheImportSelector implements ImportSelector {


    /**
     * 实现动态注入Bean
     *
     * @param annotationMetadata 注解的元信息
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        Map<String, Object> attributes = annotationMetadata.getAnnotationAttributes(EnableService.class.getName());
        Object exclude = attributes.get("exclude");
        Class<?>[] classes = (Class<?>[]) exclude;
        Set<String> names = Collections.synchronizedSet(new HashSet<>());
        names.add(CacheService.class.getName());
        names.add(LoggerService.class.getName());
        for (Class<?> clazz : classes) {
            names.remove(clazz.getName());
        }
        return names.toArray(new String[names.size()]);
    }
}
