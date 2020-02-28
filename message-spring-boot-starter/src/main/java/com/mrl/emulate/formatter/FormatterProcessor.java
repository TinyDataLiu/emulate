package com.mrl.emulate.formatter;

/**
 * @author liuchun
 * @date 2020/02/28  16:00
 */
public interface FormatterProcessor {


    /**
     * @param obj
     * @param <T>
     * @return
     */
    <T> String format(T obj);
}
