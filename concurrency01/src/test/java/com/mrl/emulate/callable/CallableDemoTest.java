package com.mrl.emulate.callable;

import com.mrl.emulate.core.Request;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author liuchun
 * @date 2018/8/31 12:09
 */
public class CallableDemoTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Test
    public void call() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Request request = new Request();
        request.setName("nihaoaaaaa");
        Future<Request> res = executorService.submit(new CallableDemo(request));
        logger.info("其他业务处理");
        String ss = "success";
        Request re = res.get();
        logger.info(re.getName());
        TimeUnit.SECONDS.sleep(10);
    }
}