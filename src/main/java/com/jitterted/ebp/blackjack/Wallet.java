package com.jitterted.ebp.blackjack;

public class Wallet {
  private int balance = 0;

  public boolean isEmpty() {
    return balance == 0;
  }

  public void addMoney(int amount) {
    balance += amount;
  }

  public int balance() {
    return balance;
  }

  public void bet(int amount) {
    ensureSufficientBalanceFor(amount);
    balance -= amount;
  }

  private void ensureSufficientBalanceFor(int amount) {
    if (amount > balance) {
      throw new IllegalArgumentException();
    }
  }
}
