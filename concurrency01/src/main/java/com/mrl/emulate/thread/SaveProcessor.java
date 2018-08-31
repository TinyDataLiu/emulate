package com.mrl.emulate.thread;

import com.mrl.emulate.core.Request;
import com.mrl.emulate.interfaces.RequestProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @author liuchun
 * @date 2018/8/31 10:18
 */
public class SaveProcessor extends Thread implements RequestProcessor {

    private Logger logger = LoggerFactory.getLogger(getClass());

    LinkedBlockingDeque<Request> requests = new LinkedBlockingDeque<>();

    @Override
    public void run() {
        for (; ; ) {
            try {
                Request request = requests.take();
                logger.info("save data：" + request);
            } catch (InterruptedException e) {
                logger.error("线程中断", e);
            }
        }
    }

    @Override
    public void process(Request request) {
        requests.add(request);
    }
}
