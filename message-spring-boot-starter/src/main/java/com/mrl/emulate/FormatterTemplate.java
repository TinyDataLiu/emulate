package com.mrl.emulate;

import com.mrl.emulate.formatter.FormatterProcessor;

/**
 * 提供统一的对外访问入口
 *
 * @author liuchun
 * @date 2020/02/28  16:33
 */
public class FormatterTemplate {

    private FormatterProcessor formatterProcessor;

    public FormatterTemplate(FormatterProcessor formatterProcessor) {
        this.formatterProcessor = formatterProcessor;
    }

    public <T> String format(T obj) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("begin:Execute format").append("<br/>");
        stringBuilder.append("Obj format result:").append(formatterProcessor.format(obj)).append("<br/>");
        return stringBuilder.toString();
    }
}
