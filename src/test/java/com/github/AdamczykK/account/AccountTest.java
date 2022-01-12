package com.github.AdamczykK.account;

import com.github.AdamczykK.account.Account;
import com.github.AdamczykK.account.Address;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.assumingThat;

class AccountTest {

    @Test
    void newAccountShouldNotBeActiveAfterCreation() {
        //given
        Account newAccount = new Account();
        //then
        assertFalse(newAccount.isActive());
//        assertThat(newAccount.isActive(), equalTo(false));
//        assertThat(newAccount.isActive(), is(false));
        assertThat(newAccount.isActive()).isFalse();
    }

    @Test
    void newAccountShouldBeActiveAfterActivation() {
        //given
        Account newAccount = new Account();
        //when
        newAccount.activate();
        //then
        assertTrue(newAccount.isActive());
//        assertThat(newAccount.isActive(), equalTo(true));
        assertThat(newAccount.isActive()).isTrue();
    }

    @Test
    void newlyCreatedAccountShouldNotHaveDefaultDeliveryAddressSet() {
        //given
        Account account = new Account();
        //when
        Address address = account.getDefaultDeliveryAddress();
        //then
        assertNull(address);
//        assertThat(address, nullValue());
        assertThat(address).isNull();
    }

    @Test
    void defaultDeliveryAddressShouldNotBeNullAfterBeingSet() {
        //given
        Address address = new Address("Reymonta", "40D");
        Account account = new Account();
        account.setDefaultDeliveryAddress(address);
        //when
        Address defaultAddress= account.getDefaultDeliveryAddress();
        //then
        assertNotNull(defaultAddress);
//        assertThat(defaultAddress, notNullValue());
        assertThat(defaultAddress).isNotNull();
    }
    @Test
    void newAccountWithNotNullAddressShouldBeActive() {
        //given
        Address address = new Address("Grzybowska", "37/101");
        //when
        Account account = new Account(address);
        //then
        assumingThat(address != null, () -> {
           assertTrue(account.isActive());
        });

    }

    @Test
    void invalidEmailShouldThrowException() {
        //given
        Account account = new Account();
        //when
        //then
        assertThrows(IllegalArgumentException.class, () -> account.setEmail("wrongEmail"));
    }

    @Test
    void validEmailShouldBeSet() {
        //given
        Account account = new Account();
        //when
        account.setEmail("kontakt@pollub.pl");
        //then
        assertThat(account.getEmail()).isEqualTo("kontakt@pollub.pl");

    }

}