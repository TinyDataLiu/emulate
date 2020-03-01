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
public class ZooKeeperDemo {

    public static final String CONNECTION_STRING = "192.168.1.153:2181";
    public static final String PATH = "/watcher_client_0";

    public static void main(String[] args) {
        try {
            ZooKeeper zooKeeper = new ZooKeeper(CONNECTION_STRING, 5000, new Watcher() {
                @Override
                public void process(WatchedEvent watchedEvent) {
                    System.err.println(String.format("watchedEvent.getType=%s", watchedEvent.getType()));
                    log.info("watchedEvent.getType={}", watchedEvent.getType());
                }
            });
            // 节点创建
            zooKeeper.create(PATH, "0".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            // 注册监听
            zooKeeper.exists(PATH, true);

            TimeUnit.SECONDS.sleep(1);
            // 修改节点的值触发监听
            zooKeeper.setData(PATH, "1".getBytes(), -1);

            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (KeeperException e) {
            e.printStackTrace();
        }
    }
}
