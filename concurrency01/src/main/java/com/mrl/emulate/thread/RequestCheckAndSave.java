package com.mrl.emulate.thread;

import com.mrl.emulate.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liuchun
 * @date 2018/8/31 10:29
 * <p>
 * <p>
 * 线程的运用，
 * 这里涉及到生产者，消费者模式
 * 以及责任链模式
 */
public class RequestCheckAndSave {

    private Logger logger = LoggerFactory.getLogger(getClass());

    private final CheckProcessor checkProcessor;

    public RequestCheckAndSave() {
        SaveProcessor saveProcessor = new SaveProcessor();
        saveProcessor.start();
        checkProcessor = new CheckProcessor(saveProcessor);
        checkProcessor.start();
    }

    public static void main(String[] args) {
        Request request = new Request();
        request.setName("thread");
        new RequestCheckAndSave().doTest(request);
    }


    public void doTest(Request request) {
        checkProcessor.process(request);
    }
}
