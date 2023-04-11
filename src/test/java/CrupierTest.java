import com.bytesw.blackjack.Crupier;
import com.bytesw.blackjack.Deck;
import com.bytesw.blackjack.Hand;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CrupierTest {

    @Test
    public void testGrabFirstHand() {
        Crupier crupier = new Crupier();
        Deck deck = new Deck();
        crupier.grabfFirstHand(deck);
        int expectedSize = 1;
        int actualSize = crupier.getHandCrupier().getHand().size();
        Assertions.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGetHandCrupier() {
        Crupier crupier = new Crupier();
        Hand handCrupier = crupier.getHandCrupier();
        Assertions.assertNotNull(handCrupier);
    }
}
