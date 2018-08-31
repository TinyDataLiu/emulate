package com.mrl.emulate.runnable;

import com.mrl.emulate.core.Request;

/**
 * @author liuchun
 * @date 2018/8/31 10:59
 */
public class RunnableProcessor {


    private final CheckProcessor checkProcessor;

    public RunnableProcessor() {
        SaveProcessor saveProcessor = new SaveProcessor();
        Thread save = new Thread(saveProcessor, "save");
        save.start();
        this.checkProcessor = new CheckProcessor(saveProcessor);
        Thread check = new Thread(checkProcessor, "check");
        check.start();
    }

    public void doTest(Request request) {
        checkProcessor.process(request);
    }
}
