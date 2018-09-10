package com.mrl.emulate.outofmemoryerror;

/**
 * @author liuchun
 * @date 2018/9/7 16:47
 * <p>
 * <p>
 * -Xoss 设置本地方法栈大小（HotSpot 不支持）
 * <p>
 * -Xss2M 设置栈大小
 * <p>
 * 虚拟机扩展栈的时候无法申请到足够的空间
 * <p>
 * 这个类谨慎运行 ， 很容易造成假死
 */
public class JavaVMStackOOM {


    private void dontStop() {
        while (true) {

        }
    }


    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }


    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
