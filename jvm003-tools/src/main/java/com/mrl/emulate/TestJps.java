package com.mrl.emulate;

import java.io.IOException;

/**
 * @author liuchun
 * @date 2018/9/18 10:38
 */
public class TestJps {


    /**
     * jps:显示所有的HotSpot虚拟机进程。
     * jsp [options][hostid]
     * -q:输出LVMID 省略主类。
     * -m:输出虚拟机进程启动时传递给主类main()函数的参数。
     * -l:输出主类全名，如果是jar包则输出jar路径。
     * -v:输出虚拟机启动线程时的参数。
     *
     * @param args
     * @throws IOException
     */


    private static final int _1MB = 1024 * 1024;


    public static void main(String[] args) throws IOException {
        int i = 0;
        for (; ; ) {
            byte[] all = new byte[_1MB];
        }
    }
}
