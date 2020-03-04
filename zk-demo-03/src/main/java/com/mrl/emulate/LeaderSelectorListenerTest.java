package com.mrl.emulate;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.apache.curator.retry.RetryOneTime;

import java.util.concurrent.TimeUnit;

public class LeaderSelectorListenerTest {

    private final static CuratorFramework client = CuratorFrameworkFactory
            .builder()
            .connectString(ConnTest.CONN_STR)
            .retryPolicy(new RetryOneTime(1000))
            .namespace(ConnTest.NAME_SPACE)
            .build();

    static {
        client.start();
    }

    public static void main(String[] args) throws Exception {
        LeaderSelectorListener listener = new LeaderSelectorListenerAdapter() {
            @Override
            public void takeLeadership(CuratorFramework curatorFramework) throws Exception {
                System.out.println("===================");
                TimeUnit.SECONDS.sleep(2);
            }
        };

        LeaderSelector leaderSelector = new LeaderSelector(client, "/leaderSelector", listener);
        leaderSelector.autoRequeue();
        leaderSelector.start();

        System.in.read();
    }
}
