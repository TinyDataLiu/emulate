package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/17 15:31
 */
public class TestGC003Age {

    private static final int _1MB = 1024 * 1024;


    /**
     * 年龄阈值配置: 这里没有测试出来， 按理说，MaxTenuringThreshold = 15 的时候，应该会进入From 区 ， 但是设置成15 的时候并没有进入form 区 ， 不知道是jvm版本问题，
     * 还是参数设置问题。
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
     * -XX:MaxTenuringThreshold=1           新生代晋升老年代为1
     * -XX:+PrintTenuringDistribution       打印年龄分布
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * -XX:MaxTenuringThreshold=1
     * <p>
     * <p>
     * Java HotSpot(TM) 64-Bit Server VM (24.80-b11) for windows-amd64 JRE (1.7.0_80-b15), built on Apr 10 2015 11:26:34 by "java_re" with unknown MS VC++:1600
     * Memory: 4k page, physical 8067900k(2329724k free), swap 10820412k(2104072k free)
     * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520 -XX:MaxNewSize=10485760
     * -XX:MaxTenuringThreshold=1 -XX:NewSize=10485760 -XX:+PrintGC -XX:+PrintGCDetails
     * -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC
     * 0.267: [GC0.267: [DefNew
     * Desired survivor size 524288 bytes, new threshold 1 (max 1)
     * - age   1:     878760 bytes,     878760 total
     * : 6351K->858K(9216K), 0.0065782 secs] 6351K->4954K(19456K), 0.0068277 secs] [Times: user=0.00 sys=0.00, real=0.01 secs]
     * 0.275: [GC0.275: [DefNew
     * Desired survivor size 524288 bytes, new threshold 1 (max 1)
     * - age   1:        136 bytes,        136 total
     * : 5038K->0K(9216K), 0.0017614 secs] 9134K->4884K(19456K), 0.0018230 secs] [Times: user=0.02 sys=0.00, real=0.00 secs]
     * Heap
     * def new generation   total 9216K, used 4178K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
     * eden space 8192K,  51% used [0x00000000f9a00000, 0x00000000f9e14820, 0x00000000fa200000)
     * from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200088, 0x00000000fa300000)
     * to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
     * tenured generation   total 10240K, used 4884K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
     * the space 10240K,  47% used [0x00000000fa400000, 0x00000000fa8c51e8, 0x00000000fa8c5200, 0x00000000fae00000)
     * compacting perm gen  total 21248K, used 2988K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
     * the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0eb050, 0x00000000fb0eb200, 0x00000000fc2c0000)
     * No shared spaces configured.
     * <p>
     * <p>
     * -XX:MaxTenuringThreshold=1
     * <p>
     * Java HotSpot(TM) 64-Bit Server VM (24.80-b11) for windows-amd64 JRE (1.7.0_80-b15), built on Apr 10 2015 11:26:34 by "java_re" with unknown MS VC++:1600
     * Memory: 4k page, physical 8067900k(2314368k free), swap 10820412k(2106708k free)
     * CommandLine flags: -XX:InitialHeapSize=20971520 -XX:MaxHeapSize=20971520
     * -XX:MaxNewSize=10485760 -XX:MaxTenuringThreshold=15 -XX:NewSize=10485760
     * -XX:+PrintGC -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -XX:+PrintTenuringDistribution
     * -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseSerialGC
     * 0.280: [GC0.280: [DefNew
     * Desired survivor size 524288 bytes, new threshold 1 (max 15)
     * - age   1:     878752 bytes,     878752 total
     * : 6186K->858K(9216K), 0.0058609 secs] 6186K->4954K(19456K), 0.0060323 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
     * 0.287: [GC0.287: [DefNew
     * Desired survivor size 524288 bytes, new threshold 15 (max 15)
     * - age   1:        136 bytes,        136 total
     * : 5118K->0K(9216K), 0.0020425 secs] 9214K->4884K(19456K), 0.0021289 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
     * Heap
     * def new generation   total 9216K, used 4260K [0x00000000f9a00000, 0x00000000fa400000, 0x00000000fa400000)
     * eden space 8192K,  52% used [0x00000000f9a00000, 0x00000000f9e28fd0, 0x00000000fa200000)
     * from space 1024K,   0% used [0x00000000fa200000, 0x00000000fa200088, 0x00000000fa300000)
     * to   space 1024K,   0% used [0x00000000fa300000, 0x00000000fa300000, 0x00000000fa400000)
     * tenured generation   total 10240K, used 4884K [0x00000000fa400000, 0x00000000fae00000, 0x00000000fae00000)
     * the space 10240K,  47% used [0x00000000fa400000, 0x00000000fa8c51e8, 0x00000000fa8c5200, 0x00000000fae00000)
     * compacting perm gen  total 21248K, used 2988K [0x00000000fae00000, 0x00000000fc2c0000, 0x0000000100000000)
     * the space 21248K,  14% used [0x00000000fae00000, 0x00000000fb0eb050, 0x00000000fb0eb200, 0x00000000fc2c0000)
     * No shared spaces configured.
     */
    public static void testPretenureSizeThreshold() {
        byte[] allocation1, allocation2, allocation3;
        allocation1 = new byte[_1MB / 4]; //如果设置成15 这里理应进入From 区
        allocation2 = new byte[4 * _1MB];//这里进行了一次 GC Eden 区分配了8M 接下来的对象分配 则需要进行GC
        allocation3 = new byte[4 * _1MB];
        allocation3 = null;
        allocation3 = new byte[4 * _1MB];
    }


    public static void main(String[] args) {
        testPretenureSizeThreshold();
    }
}
