package com.mrl.emulate.outofmemoryerror;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liuchun
 * @date 2018/9/7 15:58
 * <p>
 * <p>
 * -Xms20M 堆的最小值20M
 * -Xmx20M 堆的最大值20M
 * 将堆的最小值和最大值设置为同一个值可以避免堆的自动扩展
 * -XX:+HeapDumpOnOutOfMemoryError
 * <p>
 * java.lang.OutOfMemoryError: Java heap space 堆内存溢出
 * Dumping heap to java_pid5652.hprof ...
 * Heap dump file created [28183230 bytes in 0.132 secs]
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        for (; ; ) {
            list.add(new OOMObject());
        }
    }
}
