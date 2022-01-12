package com.github.AdamczykK.account;

import java.util.List;
import java.util.stream.Collectors;

public class AccountService {
    private AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    List<Account> getAllActiveAccounts() {
        return repository.getAllAccounts().stream()
                .filter(Account::isActive)
                .collect(Collectors.toList());
    }

    List<String> findByName(String name) {
        return repository.getByName(name);
    }
}
