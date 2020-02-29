package com.alice.zookeeper.zkdemo01;

import org.apache.curator.framework.AuthInfo;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Id;
import org.apache.zookeeper.server.auth.DigestAuthenticationProvider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author liuchun
 * @date 2020/02/29  15:55
 */
public class ZooKeeperACL {

    private static final String ZK_ADDR = "192.168.1.153:2181";

    public static void main(String[] args) throws Exception {
        // 授权信息
        AuthInfo authInfo = new AuthInfo("digest", "u2:us".getBytes());
        List<AuthInfo> authInfos = Collections.singletonList(authInfo);
        //1. 创建连接
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                // zk地址
                .connectString(ZK_ADDR)
                // 回话超时时间
                .sessionTimeoutMs(15000)
                //重试策略
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                // 命名空间
                .namespace("curator")
                // 授权信息
                .authorization(authInfos)
                .build();


        curatorFramework.start();

        //添加授权
        List<ACL> acls = new ArrayList<>();
        Id id1 = new Id("digest", DigestAuthenticationProvider.generateDigest("u1:us"));
        Id id2 = new Id("digest", DigestAuthenticationProvider.generateDigest("u2:us"));
        acls.add(new ACL(ZooDefs.Perms.ALL, id1));
        acls.add(new ACL(ZooDefs.Perms.DELETE | ZooDefs.Perms.READ, id2));

        // 创建
        curatorFramework.create().withMode(CreateMode.PERSISTENT)
                // 设置相应的权限
                .withACL(acls, false)
                .forPath("/acl", "acl".getBytes());


        curatorFramework.setData().forPath("/acl", "22222".getBytes());
        byte[] bytes = curatorFramework.getData().forPath("/acl");
        System.out.println(new String(bytes));


    }

}
