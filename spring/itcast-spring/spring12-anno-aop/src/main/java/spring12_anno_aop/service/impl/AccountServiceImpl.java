package spring12_anno_aop.service.impl;

import org.springframework.stereotype.Service;
import spring12_anno_aop.service.AccountService;

@Service
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
