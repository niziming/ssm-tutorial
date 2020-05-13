package spring15_aop_transaction_anno_withoutxml.dao;

import spring15_aop_transaction_anno_withoutxml.domain.Account;

import java.util.List;

public interface AccountDao {
    /**
     * 根据Id查询账户
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 根据名称查询账户
     * @param accountName
     * @return
     */
    Account findAccountByName(String accountName);

    /**
     * 更新账户
     * @param account
     */
    void updateAccount(Account account);

}
