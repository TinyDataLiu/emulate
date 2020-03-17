package com.alice.sentinel;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 令牌桶
 */
@Slf4j
public class RateLimiterDemo {

    private static final RateLimiter rateLimit = RateLimiter.create(100);

    private static final AtomicLong atomicLong = new AtomicLong(0);

    private static void doTest() {
        if (rateLimit.tryAcquire()) {
            log.info("顺利通过");
            atomicLong.getAndIncrement();
        } else {
            log.info("限流了");
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < 200; i++) {
            new Thread(() -> {
                doTest();
            }).start();
        }
        TimeUnit.SECONDS.sleep(2);
        log.info("{}", atomicLong.get());

        System.in.read();
    }
}
