package com.mrl.emulate;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.RetryOneTime;
import org.apache.curator.x.async.AsyncCuratorFramework;
import org.apache.curator.x.async.WatchMode;
import org.apache.zookeeper.CreateMode;

import java.io.IOException;

/**
 * 异步调用
 */
public class AsyncExamples {


    private final static CuratorFramework client = CuratorFrameworkFactory
            .builder()
            .connectString(ConnTest.CONN_STR)
            .retryPolicy(new RetryOneTime(1000))
            .namespace(ConnTest.NAME_SPACE)
            .build();

    static {
        client.start();
    }

    public static void main(String[] args) throws IOException {
        AsyncCuratorFramework async = AsyncCuratorFramework.wrap(client);
        async.checkExists().forPath("/async").whenComplete(((stat, throwable) -> {
            if (stat == null) {
                async.create().withMode(CreateMode.PERSISTENT).forPath("/async", "async".getBytes()).whenComplete((name, e) -> {
                    System.out.println(name);
                    e.printStackTrace();
                });

                async.with(WatchMode.successOnly).checkExists().forPath("/async").event().thenAccept(watchedEvent -> {

                    System.out.println(watchedEvent.getType() + "---->" + watchedEvent);
                    System.out.println(watchedEvent);

                });
            } else {
                System.out.println(" 节点存在");
            }
        }));


        System.in.read();
    }

}
