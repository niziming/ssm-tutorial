package spring08_anno_ioc_withoutxml.service;

import spring08_anno_ioc_withoutxml.domain.Account;

import java.util.List;

public interface AccountService {
    /**
     * 查询所有
     * @return List<Account>
     */
    List<Account> findAllAccount();

    /**
     *
     * @param accountId
     * @return Account
     */
    Account findAccountById(Integer accountId);

    /**
     * 保存
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 更新
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param acccountId
     */
    void deleteAccount(Integer acccountId);

}
