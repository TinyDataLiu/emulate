package com.mrl.emulate.classload;

import com.mrl.emulate.classload.passivereference1.SubClazz;
import com.mrl.emulate.classload.passivereference1.SuperClazz;
import com.mrl.emulate.classload.passivereference2.ConstClazz;
import org.junit.Ignore;
import org.junit.Test;

/**
 * 被动引用演示
 *
 * @author liuchun
 * @date 2018/9/27 16:01
 */
public class NotInitializationTest {


    /**
     * 子类调用父类的静态变量，子类不会初始化。
     */
    @Test
    @Ignore
    public void notInitialization_0() {
        System.out.println(SubClazz.value);
    }

    /**
     * 通过数组定义来引用类,不会触发类的初始化
     */
    @Test
    public void notInitialization_1() {
        SuperClazz[] superClazzes = new SuperClazz[10];
        System.out.println(superClazzes.length);
    }

    /**
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用定义常量的类，因此不会
     * 引发定义常量的类的初始化,常量的传播优化
     * <p>
     * <p>
     * 接口初始化不会要求父接口全部初始化，只有在真正引用到父接口的时候才会初始化
     */
    @Test
    @Ignore
    public void notInitialization_2() {
        System.out.println(ConstClazz.HELLO_WORLD);
    }


}