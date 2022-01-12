package com.github.AdamczykK.account;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

class AddressTest {

    @ParameterizedTest
    @CsvSource({"Reymonta, 38", "Reja, 25/74", "'Romka, Tomka i Atomka', 72"})
    void givenAddressesShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/addresses.csv")
    void addressesFromFileShouldNotBeEmptyAndHaveProperNames(String street, String number) {
        assertThat(street, notNullValue());
        assertThat(street, containsString("a"));
        assertThat(number, notNullValue());
        assertThat(number.length(), lessThan(8));
    }

}