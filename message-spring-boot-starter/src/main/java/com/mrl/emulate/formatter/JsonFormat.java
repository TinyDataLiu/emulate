package com.mrl.emulate.formatter;

import com.alibaba.fastjson.JSON;

/**
 * @author liuchun
 * @date 2020/02/28  16:02
 */
public class JsonFormat implements FormatterProcessor {
    @Override
    public <T> String format(T obj) {
        return "" + JSON.toJSONString(obj);
    }
}
