package com.alice.zookeeper.zkdemo01;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.retry.RetryUntilElapsed;
import org.apache.zookeeper.CreateMode;
import org.springframework.util.StringUtils;

import java.util.UUID;

/**
 * @author liuchun
 * @date 2020/02/29  17:06
 */
public class WatcherDemo2 {
    private static final String ZK_ADDR = "192.168.1.153:2181";

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .retryPolicy(new RetryUntilElapsed(15000, 1000))
                .connectString(ZK_ADDR).build();
        curatorFramework.start();


        try {
//            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath("/watcher", "1111".getBytes());


//            curatorFramework.setData().forPath("/watcher", "3333".getBytes());


//            curatorFramework.create().creatingParentContainersIfNeeded().forPath("/watcher/" + UUID.randomUUID().toString());


//            curatorFramework.delete().deletingChildrenIfNeeded().forPath("/watcher/4a448a9a-a6c8-4432-860e-5b6b0bc7becf");


            curatorFramework.getChildren().forPath("/watcher").forEach(path -> {
                System.out.println(path);
            });


            curatorFramework.setData().forPath("/watcher/1111", "333333".getBytes());

        } catch (Exception e) {


            e.printStackTrace();
        }

    }

    /**
     * 针对当前节点的
     *
     * @param curatorFramework
     */
    private static void addListenerWithNode(CuratorFramework curatorFramework) throws Exception {
        NodeCache nodeCache = new NodeCache(curatorFramework, "/watcher", false);
        nodeCache.getListenable().addListener(() -> {
            System.out.println("receive Node Changed");
            System.out.println(nodeCache.getCurrentData().getPath() + "----->" + new String(nodeCache.getCurrentData().getData()));
        });
        nodeCache.start();
    }


}
