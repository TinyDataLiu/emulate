package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/17 15:31
 */
public class TestGC001 {

    private static final int _1MB = 1024 * 1024;


    /**
     * 测试Serial + Serial Old
     * <p>
     * <p>
     * JDK 7 Server 模式
     * -Xms20M
     * -Xmx20M                  设置堆大小为20M 且不允许扩展
     * -Xmn10M                  设置年轻代大小为10M
     * -XX:+UseSerialGC         设置使用Serial 这里使用Serial + Serial Old
     * -XX:+PrintGCDetails      设置打印GC 日志
     * -XX:+PrintGCTimeStamps   打印日志时间
     * -Xloggc:D:/logs/gc.log   GC日志保存路径
     * <p>
     * <p>
     * JVM信息
     * Java HotSpot(TM) 64-Bit Server VM (24.80-b11) for windows-amd64 JRE (1.7.0_80-b15), built on Apr 10 2015 11:26:34 by "java_re" with unknown MS VC++:1600
     * Memory: 4k page, physical 8067900k(2449216k free), swap 10820412k(2470308k free)
     * CommandLine flags:
     * -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
     * -XX:MaxNewSize=10485760 -XX:NewSize=10485760 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     * -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC
     * #进行一次GC 当第四个对象创建的时候Minor GC
     * 0.237: [GC0.237: [DefNew: 8143K->602K(9216K), 0.0075094 secs] 8143K->6746K(19456K), 0.0076788 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * Heap
     * 新生代
     * def new generation   total 9216K, used 4863K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
     * eden space 8192K,  52% used [0x00000000f9a00000, 0x00000000f9e296c8, 0x00000000fa200000) 8M 经过一次GC 只有一个 4M 的对象存活
     * from space 1024K,  58% used [0x00000000fa300000, 0x00000000fa3968b0, 0x00000000fa400000) 1M 之类为什么还有58%的使用 ？
     * to   space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
     * 老年代
     * <p>
     * tenured generation   total 10240K, used 6144K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
     * the space 10240K,  60%  之前的三个对象6M 已经进入了老年代。 used [0x00000000fa400000, 0x00000000faa00030, 0x00000000faa00200, 0x00000000fae00000)
     * 永久代
     * compacting perm gen  total 21248K, used 2988K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
     * the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0eb060, 0x00000000fb0eb200, 0x00000000fc2c0000)
     * No shared spaces configured.
     */
    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB * 2];
        allocation2 = new byte[_1MB * 2];
        allocation3 = new byte[_1MB * 2];
        allocation4 = new byte[_1MB * 4];
    }


    public static void main(String[] args) {
        testAllocation();
    }
}
