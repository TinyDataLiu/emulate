package com.alice.zookeeper.zkdemo02;

import lombok.extern.slf4j.Slf4j;
import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * 基于zkClient 的操作
 *
 * @author liuchun
 * @date 2020/03/01  17:08
 */
@Slf4j
public class ZooKeeperDemo01 implements Watcher {

    public static final String CONNECTION_STRING = "192.168.1.153:2181";
    public static final String PATH = "/watcher_client_0";

    public static void main(String[] args) throws Exception {
        ZooKeeper zooKeeper = new ZooKeeper(CONNECTION_STRING, 4000, new ZooKeeperDemo01());
        // 如果没有就创建
        if (zooKeeper.exists(PATH, false) == null) {
            zooKeeper.create(PATH, "2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        // 使用全局的watcher
        zooKeeper.exists(PATH, true);
        // 从新定义其他的watcher
        zooKeeper.exists(PATH, event -> {
            log.info("================>event{}", event.getType());
        });

        System.in.read();
    }

    @Override
    public void process(WatchedEvent event) {
        log.info("-------event:{}", event.getType());
    }
}
