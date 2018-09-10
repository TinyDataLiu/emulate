package com.mrl.emulate.outofmemoryerror;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * 这里是方法区内存溢出
 * <p>
 * <p>
 * 设置 1.8 后不起作用，之后所有代码将基于 JDK1.7
 * -XX:PermSize=20M
 * -XX:MaxPermSize=20M
 *
 * @author liuchun
 * @date 2018/9/10 10:35
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        for (; ; ) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(Boolean.FALSE);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invoke(o, objects);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {

    }
}
