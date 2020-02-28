package com.mrl.emulate.formatter;

import java.util.Objects;

/**
 * @author liuchun
 * @date 2020/02/28  16:02
 */
public class StringFormat implements FormatterProcessor {
    @Override
    public <T> String format(T obj) {
        return Objects.toString(obj);
    }
}
