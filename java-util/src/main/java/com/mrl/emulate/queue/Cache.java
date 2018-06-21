package com.mrl.emulate.queue;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liucun
 * @Description: ${todo}
 * @date 2018/6/2113:35
 */
public class Cache<K, V> {
    //存储缓存数据
    public ConcurrentHashMap<K, V> map = new ConcurrentHashMap<K, V>();

    public DelayQueue<DelayedItem<K>> queue = new DelayQueue<DelayedItem<K>>();


    class DelayedItem<T> implements Delayed {
        //缓存的键
        private T key;
        //缓存时间
        private long timeout;

        @Override
        public long getDelay(TimeUnit unit) {
            return 0;
        }

        @Override
        public int compareTo(Delayed o) {
            return 0;
        }
    }
}
