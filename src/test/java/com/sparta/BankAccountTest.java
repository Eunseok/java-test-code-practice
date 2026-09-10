package com.sparta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {

    private BankAccount bankAccount;

    @BeforeEach
    void setUp() {
        bankAccount = new BankAccount();
        bankAccount.deposit(1000);
    }

    @Test
    void 잔액보다_많은_금액을_출금하면_예외가_발생하고_잔액이_유지된다() {
        IllegalStateException exception = assertThrows(
                IllegalStateException.class,
                () -> bankAccount.withdraw(2000)
        );

        assertAll(
                () -> assertEquals("잔액이 부족합니다.", exception.getMessage()),
                () -> assertEquals(1000, bankAccount.getBalance())
        );
    }

    @Test
    void 음수를_입금하면_예외가_발생하고_잔액은_유지된다() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.deposit(-1000)
        );

        assertAll(
                () -> assertEquals("입금액은 0보다 커야 합니다.", exception.getMessage()),
                () -> assertEquals(1000, bankAccount.getBalance())
        );
    }
}