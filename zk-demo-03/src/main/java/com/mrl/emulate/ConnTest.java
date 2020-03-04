package com.mrl.emulate;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryForever;
import org.apache.curator.retry.RetryNTimes;
import org.apache.curator.retry.RetryOneTime;
import org.apache.zookeeper.CreateMode;

import java.util.List;
import java.util.UUID;

/**
 * 通过curator 连接zk 并进行简单的增删查改
 */
public class ConnTest {

    public static final String CONN_STR = "192.168.1.153:2181";
    public static final String PATH = "/alice";
    public static final String NAME_SPACE = "ALICE_01";

    public static void main(String[] args) throws Exception {

//        重试策略

//        只试一次
        RetryOneTime retryOneTime = new RetryOneTime(1000);
//        一直重试
        RetryForever retryForever = new RetryForever(1000);
//        重试指定次数
        RetryNTimes retryNTimes = new RetryNTimes(2, 1000);
//        衰减重试
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
//        CuratorFramework curatorFramework = CuratorFrameworkFactory.newClient(CONN_STR, retryOneTime);
//        curatorFramework.start();
//        if (curatorFramework.checkExists().forPath(NAME_SPACE) == null) {
//            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath(NAME_SPACE);
//        }
//        curatorFramework.usingNamespace("ALICE_01");
//
//
//        if (curatorFramework.checkExists().forPath(PATH) == null) {
//            System.out.println(String.format("没有找到Znode：%s", PATH));
//            curatorFramework.create().withMode(CreateMode.PERSISTENT).forPath(PATH);
//        }


        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .namespace(NAME_SPACE)
                .retryPolicy(retryOneTime)
                .connectString(CONN_STR).build();

        curatorFramework.start();

        for (int i = 0; i < 10; i++) {
            if (curatorFramework.checkExists().forPath(PATH + "/" + "_" + i) == null) {
                curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(PATH + "/" + "_" + i);
            }
        }

        List<String> stringList = curatorFramework.getChildren().forPath(PATH);

        stringList.forEach(str -> {
            System.out.println(String.format("%s 下的子节点有 ，%s", PATH, str));
            try {
                curatorFramework.delete().deletingChildrenIfNeeded().forPath(PATH + "/" + str);
                System.out.println("删除" + str);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });


        byte[] bytes = curatorFramework.getData().forPath(PATH);
        System.out.println("改变前" + new String(bytes));
        curatorFramework.setData().forPath(PATH, UUID.randomUUID().toString().getBytes("UTF-8"));
        System.out.println("改变后" + new String(curatorFramework.getData().forPath(PATH)));

    }

}
