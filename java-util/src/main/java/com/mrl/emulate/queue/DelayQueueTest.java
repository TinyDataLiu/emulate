package com.mrl.emulate.queue;

import org.omg.CORBA.TIMEOUT;

import java.sql.Time;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author liucun
 * @Description: DelayQueue 的使用
 * @date 2018/6/2112:14
 */
public class DelayQueueTest {


    public static void main(String[] args) throws InterruptedException {
        ArrayList<DelayedMap<String, String>> list = new ArrayList<DelayedMap<String, String>>();
        for (int i = 0; i < 10; i++) {
            DelayedMap<String, String> delayedMap = new DelayedMap<String, String>(Integer.toString(i), UUID.randomUUID().toString(), (i + 1) * 1000, TimeUnit.MILLISECONDS);
            list.add(delayedMap);
        }
        DelayQueue<DelayedMap<String, String>> delayQueue = new DelayQueue<DelayedMap<String, String>>(list);
        while (delayQueue.peek() != null) {
            System.out.println(delayQueue.take().toString() + delayQueue.size());
        }
    }

    static class DelayedMap<K extends String, V> implements Delayed {

        private String key;
        private V value;
        //超时时间
        private long timeout;

        /**
         * @param key     键
         * @param value   值
         * @param timeout 超时时间
         */
        public DelayedMap(String key, V value, long timeout, TimeUnit unit) {
            TimeUnit NANO_UNIT = TimeUnit.NANOSECONDS;
            //统一转换成纳秒
            long NANO_UNIT_TIMEOUT = NANO_UNIT.convert(timeout, unit);
            this.key = key;
            this.value = value;
            this.timeout = System.nanoTime() + NANO_UNIT_TIMEOUT;
        }

        /**
         * @param unit
         * @return 还有多长时间到期
         */
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (o == this) {
                return 0;
            }

            if (o instanceof DelayedMap) {
                DelayedMap delayedMap = (DelayedMap) o;
                long d = getDelay(TimeUnit.NANOSECONDS) - delayedMap.getDelay(TimeUnit.NANOSECONDS);
                return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
            }

            return 0;
        }

        @Override
        public String toString() {
            return "DelayedMap{" +
                    "key='" + key + '\'' +
                    ", value=" + value +
                    ", timeout=" + timeout +
                    '}';
        }
    }
}
