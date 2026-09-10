package com.sparta;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

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

    ///여러 입력값을 테스트 할때  @ParameterizedTest
    /// @ValueSource 종류
    /// - @ValueSource(ints = {1, 2, 3})
    /// - @ValueSource(strings = {"a", "b", "c"})
    /// - @ValueSource(booleans = {true, false})
    @ParameterizedTest
    @ValueSource(ints = {-1, -10, -100})
    void 음수를_추가하면_예외가_발생한다(int invalidScore) {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> bankAccount.deposit(invalidScore)
        );
    }

    /// 입력값과 기대값이 둘 다 필요할때 @CsvSource
    @ParameterizedTest
    @CsvSource({
            "1000, 100, 1100",
            "1100, 500, 1600"
    })
    void 입금시_잔액이_입금액_만큼_증가한다(int initial, int amount, int expected ){
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(initial);

        assertEquals(initial, bankAccount.getBalance());


        bankAccount.deposit(amount);
        assertEquals(expected, bankAccount.getBalance());

    }
}