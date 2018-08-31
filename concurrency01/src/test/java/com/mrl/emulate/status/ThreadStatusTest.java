package com.mrl.emulate.status;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

/**
 * @author liuchun
 * @date 2018/8/31 12:51
 */
public class ThreadStatusTest {

    @Test
    public void testStatus() throws IOException {
        ThreadStatus threadStatus = new ThreadStatus();
        threadStatus.testStatus();
        System.in.read();
    }
}