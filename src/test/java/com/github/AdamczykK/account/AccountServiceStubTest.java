package com.github.AdamczykK.account;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class AccountServiceStubTest {

    @Test
    void getAllActiveAccounts() {
        //given
        AccountRepository accountRepositoryStub = new AccountRepositoryStub();
        AccountService service = new AccountService(accountRepositoryStub);
        //when
        List<Account> activeAccountList = service.getAllActiveAccounts();
        //then
        assertThat(activeAccountList, hasSize(2));
    }
}