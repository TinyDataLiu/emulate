package com.alice.zookeeper.zkdemo01;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

/**
 * @author liuchun
 * @date 2020/02/29  15:55
 */
public class ConnectToZooKeeper {

    private static final String ZK_ADDR = "192.168.1.153:2181";

    public static void main(String[] args) throws Exception {

        //1. 创建连接
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(ZK_ADDR)  // zk地址
                .sessionTimeoutMs(15000)  // 回话超时时间
                .retryPolicy(new ExponentialBackoffRetry(1000, 3)) //重试策略
                .namespace("curator")    // 命名空间
                .build();


        //启动
        curatorFramework.start();
        // 增
        String path = curatorFramework.create()
                .creatingParentContainersIfNeeded()
                .withMode(CreateMode.EPHEMERAL_SEQUENTIAL)
                .forPath("/alice/ZK_EPHEMERAL", "alice".getBytes("UTF-8"));
        System.out.println(path);


//        curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/alice/ZK_PERSISTENT", "PERSISTENT".getBytes());

        // 改

        curatorFramework.setData().forPath("/alice/ZK_PERSISTENT", "2222".getBytes());

        // c查
        byte[] bytes = curatorFramework.getData().forPath("/alice/ZK_PERSISTENT");
        System.out.println(new String(bytes));


        // 删
        curatorFramework.delete().forPath("/alice/ZK_PERSISTENT");
    }

}
