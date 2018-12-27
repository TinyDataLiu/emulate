package com.mrl.emulate.structure;

/**
 * @author liuchun
 * @date 2018/12/26 15:03
 */
public class ExceptionTableTest {
    public int inc() {
        int x;
        try {
            x = 1;
            return x;
        } catch (Exception e) {
            x = 2;
            return x;
        } finally {
            x = 3;
            return x;
        }
    }
}
