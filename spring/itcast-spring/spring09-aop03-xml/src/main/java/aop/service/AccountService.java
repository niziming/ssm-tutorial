package aop.service;

import aop.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();
    void transfer(String source, String target, Float money);
}
