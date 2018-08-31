package com.mrl.emulate.thread;

import com.mrl.emulate.core.Request;
import org.junit.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author liuchun
 * @date 2018/8/31 10:33
 */
public class RequestCheckAndSaveTest {

    @Test
    public void doTest() throws InterruptedException {
        Request request = new Request();
        request.setName("test thread");
        new RequestCheckAndSave().doTest(request);
        TimeUnit.SECONDS.sleep(2);
    }
}