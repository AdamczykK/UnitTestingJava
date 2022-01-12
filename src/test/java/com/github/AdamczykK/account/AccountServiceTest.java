package com.github.AdamczykK.account;

import org.junit.jupiter.api.Test;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@MockitoSettings(strictness = Strictness.STRICT_STUBS)
public class AccountServiceTest {
    @Test
    void getAllActiveAccounts() {
        //given
        List<Account> accounts = prepareAccountData();
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(accountRepository);
//        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        given(accountRepository.getAllAccounts()).willReturn(accounts);
        //when
        List<Account> activeAccountList = service.getAllActiveAccounts();
        //then
        assertThat(activeAccountList, hasSize(2));
    }

    @Test
    void getNoActiveAccounts() {
        //given
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(accountRepository);
//        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        given(accountRepository.getAllAccounts()).willReturn(List.of());
        //when
        List<Account> activeAccountList = service.getAllActiveAccounts();
        //then
        assertThat(activeAccountList, hasSize(0));
    }

    @Test
    void getAccountsByName() {
        //given
        AccountRepository accountRepository = mock(AccountRepository.class);
        AccountService service = new AccountService(accountRepository);
//        when(accountRepository.getAllAccounts()).thenReturn(accounts);
        given(accountRepository.getByName("dawid")).willReturn(Collections.singletonList("nowak"));
        //when
        List<String> accountNames = service.findByName("dawid");
        //then
        assertThat(accountNames.get(0), equalTo("nowak"));
    }

    List<Account> prepareAccountData() {
        Account account1 = new Account(new Address("Kwiatowa", "23C"));
        Account account2 = new Account();
        Account account3 = new Account(new Address("Reymonta", "42/67"));

        return Arrays.asList(account1, account2, account3);
    }
}
