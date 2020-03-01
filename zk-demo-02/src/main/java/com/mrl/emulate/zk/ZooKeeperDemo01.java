package com.mrl.emulate.zk;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author liuchun
 * @date 2020/03/01  18:00
 */
public class ZooKeeperDemo01 {

    public static final String CONNECTION_STRING = "192.168.1.153:2181";
    public static final String PATH = "/watcher_client_0";

    static ZooKeeper zooKeeper;

    static {
        try {
            zooKeeper = new ZooKeeper(CONNECTION_STRING, 4000, new Watcher() {
                @Override
                public void process(WatchedEvent event) {
                    System.out.println(String.format("event=%s", event.getType()));

                    try {
                        byte[] data = zooKeeper.getData(PATH, true, new Stat());
                        System.out.println("data = " + new String(data));
                    } catch (KeeperException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {
        // 监听事件只会触发一次
        if (zooKeeper.exists(PATH, true) == null) {
            zooKeeper.create(PATH, "3333".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }
        System.in.read();
    }
}
