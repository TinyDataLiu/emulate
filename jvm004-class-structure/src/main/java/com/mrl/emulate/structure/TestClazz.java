package com.mrl.emulate.structure;

/**
 * @author liuchun
 * @date 2018/9/27 12:46
 */
public class TestClazz {

    private int m;

    public int inc() {
        return m + 1;
    }


    public int inc2() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
        }
    }

}
