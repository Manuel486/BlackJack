import com.bytesw.blackjack.Hand;
import com.bytesw.blackjack.Player;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @Test
    public void testGetHandPlayer(){
        Player player = new Player(100.00);
        Hand handPlayer = player.getHandPlayer();
        assertNotNull(handPlayer);
    }

    @Test
    public void testGetBalance() {
        Player player = new Player(100.0);
        double balance = player.getBalance();
        assertEquals(100.0, balance);
    }

    @Test
    public void testSetBalance() {
        Player player = new Player(100.0);
        player.setBalance(50.0);
        double balance = player.getBalance();
        assertEquals(50.0, balance);
    }

    @Test
    public void testDeductBalance() {
        Player player = new Player(100.0);
        player.deductBalance(20.0);
        double balance = player.getBalance();
        assertEquals(80.0, balance);
    }

    @Test
    public void testIncreaseBalance() {
        Player player = new Player(100.0);
        player.increaseBalance(50.0);
        double balance = player.getBalance();
        assertEquals(150.0, balance);
    }
}
