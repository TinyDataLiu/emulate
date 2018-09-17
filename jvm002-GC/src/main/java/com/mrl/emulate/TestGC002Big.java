package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/17 15:31
 */
public class TestGC002Big {

    private static final int _1MB = 1024 * 1024;


    /**
     * 测试Serial + Serial Old  大对象直接分配至老年代
     * <p>
     * <p>
     * JDK 7 Server 模式
     * -Xms20M
     * -Xmx20M                              设置堆大小为20M 且不允许扩展
     * -Xmn10M                              设置年轻代大小为10M
     * -XX:+UseSerialGC                     设置使用Serial 这里使用Serial + Serial Old
     * -XX:+PrintGCDetails                  设置打印GC 日志
     * -XX:+PrintGCTimeStamps               打印日志时间
     * -Xloggc:D:/logs/gc.log               GC日志保存路径
     * -XX:PretenureSizeThreshold=3145728   大对象分配阈值为3M
     * <p>
     * <p>
     * Java HotSpot(TM) 64-Bit Server VM (24.80-b11) for windows-amd64 JRE (1.7.0_80-b15), built on Apr 10 2015 11:26:34 by "java_re" with unknown MS VC++:1600
     * Memory: 4k page, physical 8067900k(2497056k free), swap 10820412k(2249808k free)
     * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760 -XX:NewSize=10485760
     * -XX:PretenureSizeThreshold=3145728 -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps
     * -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC
     * Heap
     * def new generation   total 9216K, used 2163K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
     * eden space 8192K,  26%  几乎没有使用， 但是老年代已经使用了4M used [0x00000000f9a00000, 0x00000000f9c1cc60, 0x00000000fa200000)
     * from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200000, 0x00000000fa300000)
     * to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
     * tenured generation   total 10240K, used 4096K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
     * the space 10240K,  40% 对象直接进入了老年代， 所以这里直接用了40% used [0x00000000fa400000, 0x00000000fa800010, 0x00000000fa800200, 0x00000000fae00000)
     * compacting perm gen  total 21248K, used 2988K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
     * the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0eb008, 0x00000000fb0eb200, 0x00000000fc2c0000)
     * No shared spaces configured.
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4 * _1MB];
    }


    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
