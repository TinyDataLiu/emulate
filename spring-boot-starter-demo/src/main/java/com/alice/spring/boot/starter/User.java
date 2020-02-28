package com.alice.spring.boot.starter;

import java.io.Serializable;

/**
 * @author liuchun
 * @date 2020/02/28  16:42
 */
public class User implements Serializable {
    private static final long serialVersionUID = 7039366150852916294L;

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
