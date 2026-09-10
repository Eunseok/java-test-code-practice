package com.sparta;

public class BankAccount {
    private int balance;

    public void withdraw(int amount) {
        if (amount > balance) {
            throw new IllegalStateException("잔액이 부족합니다.");
        }
        balance -= amount;
    }

    public void deposit(int amount) {
        if(amount < 0) {
            throw new IllegalArgumentException("입금액은 0보다 커야 합니다.");
        }
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }
}