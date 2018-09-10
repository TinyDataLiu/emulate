package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/10 11:20
 * <p>
 * <p>
 * 开启GC 日志
 * -XX:+PrintGCDetails  详情
 * -XX:+PrintGC         非详情
 * <p>
 * <p>
 * 这里垃圾回收机制还是回收 ， 说明 不是用的引用计数法来判断对象是否存活
 * <p>
 * [GC [PSYoungGen: 7273K->664K(36864K)] 7273K->664K(120832K), 0.0022181 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
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
