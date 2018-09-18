package com.mrl.emulate;

/**
 * 空间分配担保配置
 *
 * @author liuchun
 * @date 2018/9/17 15:31
 * <p>
 * -Xms20M
 * -Xmx20M                                  固定内存
 * -Xmn10M                                  新生代10M
 * -XX:+UseSerialGC                         使用Serial + Serial Old
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps                   打印日志
 * -XX:+HandlePromotionFailure              允许担保失败
 * -Xloggc:D:/logs/gc.log                   日志输出路径
 * <p>
 * HandlePromotionFailure 是否允许担保失败（可以防止过于频繁的Full GC HandlePromotionFailure; support was removed in 6.0_24）
 * <p>
 * 发生Minor GC 之前，虚拟机会检查老年代最大可用连续空间是否大于新生代所有对象的空间。
 * 如果条件成立，Minor GC 是安全的。如果不成立，虚拟机则会查看HandlePromotionFailur
 * <p>
 * 设置是否允许担保失败,如果允许就进行GC当然这里如果失败，会进行Full GC，
 * 这里担保失败的判定是根据之前的回收新生代回收对象的平均大小,
 */
public class TestGC004HandlePromotion {

    private static final int _1MB = 1024 * 1024;


    public static void testHandlePromotion() {
        byte[] allocation1, allocation2, allocation3, allocation4, allocation5, allocation6, allocation7;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation1 = null;
        allocation4 = new byte[2 * _1MB];
        allocation5 = new byte[2 * _1MB];
        allocation6 = new byte[2 * _1MB];
        allocation4 = null;
        allocation5 = null;
        allocation6 = null;
        allocation7 = new byte[2 * _1MB];
    }


    public static void main(String[] args) {
        testHandlePromotion();
    }
}
