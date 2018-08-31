package com.mrl.emulate.thread;

import com.mrl.emulate.core.Request;
import com.mrl.emulate.interfaces.RequestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuchun
 * @date 2018/8/31 10:24
 */
public class CheckProcessor extends Thread implements RequestProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    /**
     * 下一个处理器
     */
    private final RequestProcessor nextProcessor;

    public CheckProcessor(RequestProcessor requestProcessor) {
        this.nextProcessor = requestProcessor;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Request request = requests.take();
                logger.info("data check:" + request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                logger.info("线程中断", e);
            }
        }
    }

    @Override
    public void process(Request request) {
        requests.add(request);
    }
}
