package spring14_aop_transaction.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring14_aop_transaction.dao.AccountDao;
import spring14_aop_transaction.domain.Account;
import spring14_aop_transaction.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public Account findAccountById(Integer accountId) {
        Account accountById = accountDao.findAccountById(1);
        return accountById;
    }

    @Override
    public Account findAccountByName(String accountName) {
        return null;
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);
    }

    @Override
    public void transfer(Integer source, Integer target, Float money) {
        System.out.println("transfer....");
        //2.1根据名称查询转出账户
        Account sourceAccount = accountDao.findAccountById(source);
        //2.2根据名称查询转入账户
        Account targetAccount = accountDao.findAccountById(target);
        System.out.println("转出账户" + sourceAccount);
        System.out.println("转入账户" + targetAccount);
        //2.3转出账户减钱
        sourceAccount.setMoney(sourceAccount.getMoney()-money);
        //2.4转入账户加钱
        targetAccount.setMoney(targetAccount.getMoney()+money);
        //2.5更新转出账户
        accountDao.updateAccount(sourceAccount);
//            int i=1/0;
        //2.6更新转入账户
        accountDao.updateAccount(targetAccount);
        System.out.println("转账成功");
        System.out.println("转出账户" + accountDao.findAccountById(source));
        System.out.println("转入账户" + accountDao.findAccountById(target));
    }
}
