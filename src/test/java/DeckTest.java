import com.bytesw.blackjack.Card;
import com.bytesw.blackjack.Deck;
import com.bytesw.blackjack.Rank;
import com.bytesw.blackjack.Stick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeckTest {
    @Test
    public void testDeckShuffle(){
        Deck deck1 = new Deck();
        Deck deck2 = new Deck();
        deck1.shuffle();
        deck2.shuffle();
        assertNotEquals(deck1.getDeck(), deck2.getDeck());
    }

    @Test
    public void testTakeCard(){
        Deck deck = new Deck();
        int initialSize = deck.getDeck().size();
        Card card = deck.takeCard();
        int finalSize = deck.getDeck().size();
        assertEquals(initialSize-1,finalSize);
        assertNotNull(card);
    }
}
