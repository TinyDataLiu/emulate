package com.alice.spring.boot.actuator.jmx;

import javax.management.*;
import java.io.IOException;
import java.lang.management.ManagementFactory;

/**
 * @author liuchun
 * @date 2020/02/29  12:53
 */
public class JMXMain {

    public static void main(String[] args) throws MalformedObjectNameException, NotCompliantMBeanException, InstanceAlreadyExistsException, MBeanRegistrationException, IOException {
        MBeanServer mBeanServer = ManagementFactory.getPlatformMBeanServer();
        ObjectName objectName = new ObjectName("com.alice.spring.boot.actuator.jmx.MachineMBeanImpl:type=machineMBeanImpl");
        MachineMBean machineMBean = new Machine();
        mBeanServer.registerMBean(machineMBean, objectName);
        System.in.read();
    }
}
