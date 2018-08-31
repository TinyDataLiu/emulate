package com.mrl.emulate.callable;

import com.mrl.emulate.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;

/**
 * @author liuchun
 * @date 2018/8/31 12:06
 */
public class CallableDemo implements Callable<Request> {

    private Logger logger = LoggerFactory.getLogger(getClass());


    private final Request request;

    public CallableDemo(Request request) {
        this.request = request;
    }


    @Override
    public Request call() throws Exception {
        if (request == null) {
            throw new RuntimeException("请求信息为null:" + request);
        }
        request.setName("change");
        return request;
    }
}
