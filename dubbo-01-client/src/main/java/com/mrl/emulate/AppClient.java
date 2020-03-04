package com.mrl.emulate;

import com.mrl.emulate.api.LoginService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class AppClient {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("META-INF/spring/application.xml");


        LoginService loginService = context.getBean(LoginService.class);

        String login = loginService.login("alice", "amdin");
        System.out.println(">>>>>>>>>>>>>" + login);
    }
}
