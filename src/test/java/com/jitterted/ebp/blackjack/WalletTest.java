package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WalletTest {

  @Test
  public void newWalletIsEmpty() throws Exception {
    // Given a new wallet
    Wallet wallet = new Wallet();

    // When the wallet is new

    // Then isEmpty = true
    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void addMoneyToNewWalletIsEmptyIsFalse() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(10);

    assertThat(wallet.isEmpty())
        .isFalse();
  }

  @Test
  public void newWalletHasZeroBalance() throws Exception {
    Wallet wallet = new Wallet();

    assertThat(wallet.balance())
        .isZero();
  }

  @Test
  public void add12WallHasBalanceOf12() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(12);

    assertThat(wallet.balance())
        .isEqualTo(12);
  }

  @Test
  public void add17AndAdd19HasBalanceOf36() throws Exception {
    Wallet wallet = new Wallet();

    wallet.addMoney(17);
    wallet.addMoney(19);

    assertThat(wallet.balance())
        .isEqualTo(17 + 19);
  }

}
