package spring09_aop_account.service;

import spring09_aop_account.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

}
