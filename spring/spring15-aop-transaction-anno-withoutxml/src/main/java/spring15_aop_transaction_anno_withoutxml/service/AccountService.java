package spring15_aop_transaction_anno_withoutxml.service;

import spring15_aop_transaction_anno_withoutxml.domain.Account;

/**
 * 账户的业务层接口
 */
public interface AccountService {
    /**
     * 根据id查询账户信息
     * @param accountId
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 转账
     * @param sourceName    转成账户名称
     * @param targetName    转入账户名称
     * @param money         转账金额
     */
    void transfer(String sourceName,String targetName,Float money);
}
