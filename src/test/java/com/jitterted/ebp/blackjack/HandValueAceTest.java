package com.jitterted.ebp.blackjack;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class HandValueAceTest {

  private static final Suit DUMMY_SUIT = Suit.HEARTS;

  @Test
  public void handWithOneAceTwoCardsIsValuedAt11() throws Exception {
    Hand hand = createHand("A", "9");

    assertThat(hand.value())
        .isEqualTo(11 + 9);
  }

  @Test
  public void handWithOneAceAndOtherCardsValuedAt10IsValuedAt11() throws Exception {
    Hand hand = createHand("A", "10");

    assertThat(hand.value())
        .isEqualTo(11 + 10);
  }

  @Test
  public void handWithOneAceAndOtherCardsEqualTo11IsValuedAt1() throws Exception {
    Hand hand = createHand("A", "8", "3");

    assertThat(hand.value())
        .isEqualTo(1 + 8 + 3);
  }

  private Hand createHand(String... ranks) {
    Hand hand = new Hand();
    Arrays.stream(ranks).forEach(rank -> hand.add(new Card(DUMMY_SUIT, rank)));
    return hand;
  }

}
