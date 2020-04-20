package module.service.impl;

import module.service.AccountService;

import java.util.Date;

public class AccountServiceImpl implements AccountService {
    private String name;
    private Integer age;
    private Date brithday;

    public AccountServiceImpl(String name, Integer age, Date brithday) {
        this.name = name;
        this.age = age;
        this.brithday = brithday;
    }

    public void saveAccount() {

    }
}
