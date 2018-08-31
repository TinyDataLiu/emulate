package com.mrl.emulate.runnable;

import com.mrl.emulate.core.Request;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author liuchun
 * @date 2018/8/31 11:02
 */
public class RunnableProcessorTest {

    @Test
    public void doTest() throws InterruptedException {
        Request request = new Request();
        request.setName("runnable test!");
        new RunnableProcessor().doTest(request);
        TimeUnit.SECONDS.sleep(5);
    }
}