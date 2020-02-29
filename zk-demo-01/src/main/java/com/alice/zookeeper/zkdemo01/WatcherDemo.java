package com.alice.zookeeper.zkdemo01;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.recipes.cache.*;
import org.apache.curator.retry.RetryUntilElapsed;

/**
 * @author liuchun
 * @date 2020/02/29  17:06
 */
public class WatcherDemo {
    private static final String ZK_ADDR = "192.168.1.153:2181";

    public static void main(String[] args) {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .retryPolicy(new RetryUntilElapsed(15000, 1000))
                .connectString(ZK_ADDR).build();
        curatorFramework.start();

        try {
//            addListenerWithNode(curatorFramework);
            addListenerWithChild(curatorFramework);
            System.in.read();
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

    private static void addListenerWithChild(CuratorFramework curatorFramework) throws Exception {
        PathChildrenCache pathChildrenCache = new PathChildrenCache(curatorFramework, "/watcher", false);
        pathChildrenCache.getListenable().addListener((curatorFramework1, pathChildrenCacheEvent) -> {
            System.out.println(pathChildrenCacheEvent.getType() + "------>" + pathChildrenCacheEvent.getData());
        });
        pathChildrenCache.start();
    }
}
