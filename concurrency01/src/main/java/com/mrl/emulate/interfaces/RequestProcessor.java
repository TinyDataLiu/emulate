package com.mrl.emulate.interfaces;

import com.mrl.emulate.core.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author liuchun
 * @date 2018/8/31 10:16
 */
public interface RequestProcessor {

    /**
     * 处理请求
     *
     * @param request
     */
    default void process(Request request) {
    }
}
