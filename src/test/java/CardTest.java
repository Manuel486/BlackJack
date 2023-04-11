import com.bytesw.blackjack.Card;
import com.bytesw.blackjack.Rank;
import com.bytesw.blackjack.Stick;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CardTest {

    @Test
    public void testConstructorAndGetters() {
        Stick expectedStick = Stick.HEART;
        Rank expectedRank = Rank.ACE;
        Card card = new Card(expectedStick, expectedRank);
        assertEquals(expectedStick, card.getStick());
        assertEquals(expectedRank, card.getRank());
    }

    @Test
    public void testCopyConstructor() {
        Stick expectedStick = Stick.DIAMOND;
        Rank expectedRank = Rank.TWO;
        Card originalCard = new Card(expectedStick, expectedRank);
        Card copiedCard = new Card(originalCard);
        assertEquals(expectedStick, copiedCard.getStick());
        assertEquals(expectedRank, copiedCard.getRank());
    }

    @Test
    public void testSetStickAndRank(){
        Stick expectedStick = Stick.SPADE;
        Rank expectedRank = Rank.TWO;
        Card card = new Card(expectedStick,expectedRank);
        card.setStick(Stick.HEART);
        card.setRank(Rank.FOUR);
        assertEquals(Stick.HEART,card.getStick());
        assertEquals(Rank.FOUR,card.getRank());
    }

    @Test
    public void testToString() {
        Stick expectedStick = Stick.CLUB;
        Rank expectedRank = Rank.JACK;
        Card card = new Card(expectedStick, expectedRank);
        String expectedString = "[" + expectedStick + " " + expectedRank + "] ";
        assertEquals(expectedString, card.toString());
    }
}
