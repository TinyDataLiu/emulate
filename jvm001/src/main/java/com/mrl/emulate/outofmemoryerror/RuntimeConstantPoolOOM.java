package com.mrl.emulate.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchun
 * @date 2018/9/10 09:19
 * <p>
 * <p>
 * 方法区异常OutOfMemoryError
 * <p>
 * -XX:PermSize=2M
 * -XX:MaxPerSize=2M
 * <p>
 * 这两个配置已经在 1.8中移除
 * 所以这样配置不会起作用了
 * <p>
 * <p>
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option PermSize=2M; support was removed in 8.0
 * Java HotSpot(TM) 64-Bit Server VM warning: ignoring option MaxPermSize=2M; support was removed in 8.0
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用list保持常量池引用 ， 防止FullGc 回收
        List<String> list = new ArrayList<>();
        int i = 0;
        for (; ; ) {
            i++;
            list.add((String.valueOf(i) + "DISCONNECTEDDISCONNECTEDDISCONNECTEDDISCONNECTED").intern());
        }
    }
}
