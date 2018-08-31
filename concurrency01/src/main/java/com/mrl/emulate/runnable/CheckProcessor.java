package com.mrl.emulate.runnable;

import com.mrl.emulate.core.Request;
import com.mrl.emulate.interfaces.RequestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuchun
 * @date 2018/8/31 10:39
 */
public class CheckProcessor implements Runnable, RequestProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    private final RequestProcessor nextProcessor;

    public CheckProcessor(RequestProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    @Override
    public void run() {
        for (; ; ) {
            try {
                Request request = requests.take();
                logger.info("check data:" + request);
                nextProcessor.process(request);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    @Override
    public void process(Request request) {
        requests.add(request);
    }
}
