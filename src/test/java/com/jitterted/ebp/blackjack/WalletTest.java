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

  @Test
  public void walletWith45Bet44BalanceIs1() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(45);

    wallet.bet(44);

    assertThat(wallet.balance())
        .isEqualTo(45 - 44);
  }

  @Test
  public void walletWith55Bet18AndBet17BalanceIs20() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(55);

    wallet.bet(18);
    wallet.bet(17);

    assertThat(wallet.balance())
        .isEqualTo(55 - 18 - 17);
  }

  @Test
  public void betFullBalanceResultsInWalletIsEmpty() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(37);

    wallet.bet(37);

    assertThat(wallet.isEmpty())
        .isTrue();
  }

  @Test
  public void betMoreThanBalanceThrowsException() throws Exception {
    Wallet wallet = new Wallet();
    wallet.addMoney(73);

    assertThatThrownBy(() -> {
      wallet.bet(74);
    })
        .isInstanceOf(IllegalArgumentException.class);
  }

}
