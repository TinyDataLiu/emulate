package com.alice.dubbo.provider.dubbo03provider;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Filter;

import java.util.List;

public class AdaptiveTest {
    public static void main(String[] args) {
//        Compiler adaptiveExtension = ExtensionLoader
//                .getExtensionLoader(Compiler.class)
//                .getAdaptiveExtension();
//        System.out.println(adaptiveExtension.getClass());


        ExtensionLoader<Filter> extensionLoader = ExtensionLoader.getExtensionLoader(Filter.class);
        URL url = new URL("", "", 0);
//        url.addParameter("cache", "cache");
        List<Filter> cache = extensionLoader.getActivateExtension(url, "111");
        System.out.println(cache.size());
    }
}
