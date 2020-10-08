package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class GameBettingTest {

  @Test
  public void newGamePlayerBalanceIs100() throws Exception {
    Game game = new Game();

    assertThat(game.playerBalance())
        .isEqualTo(100);
  }

  @Test
  public void newGamePlayerBets40BalanceIs60() throws Exception {
    Game game = new Game();

    game.playerBets(40);

    assertThat(game.playerBalance())
        .isEqualTo(100 - 40);

  }

  @Test
  public void playerWith100Bets20playerWinsBalance70() throws Exception {
    Game game = new Game();
    game.playerBets(20);

    game.playerWins();

    assertThat(game.playerBalance())
        .isEqualTo(100 - 20 + (2 * 20));
  }

}