import com.bytesw.blackjack.Player;
import com.bytesw.blackjack.ResultGame;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ResultGameTest {

    @Test
    public void testResultGameWin(){
        Player player = new Player(100.0);
        ResultGame resultGame = new ResultGame(player,10.00,true,10);
        String expected = "[ Resultado:Ganó   Aposto:10.0   Ganó:10.0]";
        String actual = resultGame.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testResultGameLose(){
        Player player = new Player(100.0);
        ResultGame resultGame = new ResultGame(player,10.00,false,10);
        String expected = "[ Resultado:Perdió   Aposto:10.0   Perdió:10.0]";
        String actual = resultGame.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetAndSetPlayer() {
        Player player = new Player(100.00);
        double bet = 10.0;
        boolean result = true;
        double totalProfitOrLoss = 20.0;
        ResultGame resultGame = new ResultGame(player, bet, result, totalProfitOrLoss);

        Player expected = new Player(50.00);
        resultGame.setPlayer(expected);
        Player actual = resultGame.getPlayer();

        assertEquals(expected, actual);
    }

    @Test
    public void testGetAndSetBet() {
        Player player = new Player(100.0);
        double bet = 10.0;
        boolean result = true;
        double totalProfitOrLoss = 20.0;
        ResultGame resultGame = new ResultGame(player, bet, result, totalProfitOrLoss);

        double expected = 15.0;
        resultGame.setBet(expected);
        double actual = resultGame.getBet();

        assertEquals(expected, actual);
    }

    @Test
    public void testIsAndSetResult() {
        Player player = new Player(100.0);
        double bet = 10.0;
        boolean result = true;
        double totalProfitOrLoss = 20.0;
        ResultGame resultGame = new ResultGame(player, bet, result, totalProfitOrLoss);

        boolean expected = false;
        resultGame.setResult(expected);
        boolean actual = resultGame.isResult();

        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        Player player = new Player(100.0);
        double bet = 10.0;
        boolean result = true;
        double totalProfitOrLoss = 20.0;
        ResultGame resultGame = new ResultGame(player, bet, result, totalProfitOrLoss);

        String expected = "[ Resultado:Ganó   Aposto:10.0   Ganó:20.0]";
        String actual = resultGame.toString();

        assertEquals(expected, actual);
    }
}
