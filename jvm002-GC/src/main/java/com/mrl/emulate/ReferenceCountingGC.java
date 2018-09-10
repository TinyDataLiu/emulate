package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/10 11:20
 * <p>
 * <p>
 * 开启GC 日志
 * -XX:+PrintGCDetails  详情
 * -XX:+PrintGC         非详情
 */
public class ReferenceCountingGC {

    public Object instance = null;


    private static final int _1MB = 1024 * 1024;

    /**
     * 占用内存， 在查看的时候方便查看GC 日志
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {
        ReferenceCountingGC a = new ReferenceCountingGC();
        ReferenceCountingGC b = new ReferenceCountingGC();

        a.instance = b;
        b.instance = a;

        a = null;
        b = null;

        System.gc();
    }

}
