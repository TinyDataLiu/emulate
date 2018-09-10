package com.mrl.emulate;

/**
 * @author liuchun
 * @date 2018/9/10 12:47
 * <p>
 * <p>
 * 1.对象可以被GC 的时候可以被自救。
 * 2.只有一次自救机会
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;


    public void isAlive() {
        System.out.println(" I am still alive :)");
    }


    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(" finalize method is executed");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        //
        SAVE_HOOK = new FinalizeEscapeGC();
        //对象第一次成功拯救自己
        SAVE_HOOK = null;
        System.gc();
        //等待finalize()方法执行
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead :(");
        }
        //
        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("I am dead :(");
        }

    }
}
