package com.mrl.emulate.outofmemoryerror;

/**
 * @author liuchun
 * @date 2018/9/7 16:47
 * <p>
 * <p>
 * -Xoss 设置本地方法栈大小（HotSpot 不支持）
 * <p>
 * -Xss2M 设置栈大小
 */
public class JavaVMStackOOM {


    private void dontStop() {
        while (true) {

        }
    }


    private void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(() -> {
                dontStop();
            });
            thread.start();
        }


    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThread();
    }

}
