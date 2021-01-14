package di.service.impl;

import di.service.AccountService;

import java.util.Date;

/**
 * 使用p名称空间注入数据（本质还是调用set方法）
 */
public class ImplNamespaceP implements AccountService {
    String name;
    Integer age;
    Date birthday;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }


    @Override
    public void saveAccount() {
        System.out.println(name + " - " + age + " - " + birthday + "Namespace");
    }
}
