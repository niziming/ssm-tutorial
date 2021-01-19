package aop.service;

import aop.domain.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAllAccount();
    Account findAccountById(Integer accountId);


}
