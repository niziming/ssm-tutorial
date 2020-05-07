package spring11_aop.service.impl;

import spring11_aop.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("执行了保存用户");
    }
    @Override
    public void updateAccount(int i) {
        System.out.println("执行了更新用户");

    }
    @Override
    public int deleteAccount() {
        System.out.println("执行了删除用户");
        return 0;
    }
}
