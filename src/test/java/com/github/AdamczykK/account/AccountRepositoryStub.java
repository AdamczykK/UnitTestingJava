package com.github.AdamczykK.account;

import java.util.Arrays;
import java.util.List;

public class AccountRepositoryStub implements AccountRepository{
    @Override
    public List<Account> getAllAccounts() {
        Account account1 = new Account(new Address("Kwiatowa", "23C"));
        Account account2 = new Account();
        Account account3 = new Account(new Address("Reymonta", "42/67"));

        return Arrays.asList(account1, account2, account3);
    }

    @Override
    public List<String> getByName(String name) {
        return null;
    }
}
