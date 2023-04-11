import com.bytesw.blackjack.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HandTest {

    @Test
    public void testTakeCardFromDeck(){
        Hand hand = new Hand();
        Deck deck = new Deck();
        int expectedSize = 1;
        hand.takeCardFromDeck(deck);
        int actualSize = hand.getHand().size();
        assertEquals(expectedSize,actualSize);
    }

    @Test
    public void testSetAndGet(){
        Card card = new Card(Stick.SPADE, Rank.FOUR);
        ArrayList<Card> hands = new ArrayList<>();
        hands.add(card);
        Hand hand = new Hand();
        hand.setHand(hands);
        assertEquals(card,hand.getCard(0));
    }
}
