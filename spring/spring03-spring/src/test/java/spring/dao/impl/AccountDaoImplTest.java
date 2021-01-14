package spring.dao.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import spring.dao.IAccountDao;

public class AccountDaoImplTest {
    private IAccountDao accountDao;
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void saveAccount() {
        accountDao.saveAccount();
    }
}