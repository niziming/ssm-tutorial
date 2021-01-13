package spring01decoupling;
//业务层调用持久层，并且此时业务层在依赖持久层的接口和实现类。如果此时没有持久层实现类，编译
//        将不能通过。这种编译期依赖关系，应该在我们开发中杜绝。我们需要优化代码解决。
//public class AccountServiceImpl1 implements IAccountService{
//    private IAccountDao accountDao = new AccountServiceImpl1();
//}
