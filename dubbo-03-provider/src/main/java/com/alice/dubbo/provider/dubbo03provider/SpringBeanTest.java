package com.alice.dubbo.provider.dubbo03provider;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.*;
import org.springframework.context.event.ContextRefreshedEvent;

public class SpringBeanTest implements InitializingBean, DisposableBean

        , ApplicationContextAware, ApplicationListener<ContextRefreshedEvent>
        , BeanNameAware, ApplicationEventPublisherAware {

    /**
     * InitializingBean bean 初始化的时候调用
     *
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {

    }

    /**
     * DisposableBean Bean销毁的时候调用，大多用于资源的释放
     *
     * @throws Exception
     */
    @Override
    public void destroy() throws Exception {

    }


    /**
     * ApplicationContextAware ,实现了这个接口的 bean，当 spring 容器初始化的时候，会自动的将 ApplicationContext 注入进来
     *
     * @param applicationContext
     * @throws BeansException
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

    }

    /**
     * ApplicationListener容器刷新的时候调用
     *
     * @param contextRefreshedEvent
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

    }


    /**
     * BeanNameAware 获得自身初始化时，本身的 bean 的 id 属性，被重写的方法为 setBeanName
     *
     * @param s
     */
    @Override
    public void setBeanName(String s) {

    }

    /**
     * ApplicationEventPublisherAware
     *
     * @param applicationEventPublisher
     */
    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {

    }
}
