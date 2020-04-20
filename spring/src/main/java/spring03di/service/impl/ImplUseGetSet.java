package spring03di.service.impl;

import spring03di.service.AccountService;

import java.util.Date;

public class ImplUseGetSet implements AccountService {
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
        System.out.println(name + " - " + age + " - " + birthday );
    }
}
