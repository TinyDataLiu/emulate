package com.mrl.emulate.outofmemoryerror;

/**
 * @author liuchun
 * @date 2018/9/7 16:47
 * <p>
 * <p>
 * -Xoss 设置本地方法栈大小（HotSpot 不支持）
 * <p>
 * -Xss128k 设置栈大小
 * <p>
 * <p>
 * StackOverflowError   方法申请栈深度，小于虚拟机最大允许的栈深度。
 */
public class JavaVMStackSOF {

    private int stackLength = 1;


    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF javaVMStackSOF = new JavaVMStackSOF();
        try {
            javaVMStackSOF.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length=" + javaVMStackSOF.stackLength);
            e.printStackTrace();
        }
    }

}
