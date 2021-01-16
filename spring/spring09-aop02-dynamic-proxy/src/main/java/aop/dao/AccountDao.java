package aop.dao;

import aop.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);
}
