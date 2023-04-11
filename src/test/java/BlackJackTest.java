import com.bytesw.blackjack.BlackJack;
import com.bytesw.blackjack.Player;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BlackJackTest {
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testEnterBalance(){
        //ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        //System.setOut(new PrintStream(outContent));
        ByteArrayInputStream inContent = new ByteArrayInputStream("2\n100\n0\n".getBytes());
        System.setIn(inContent);
        BlackJack blackJack = new BlackJack();
        String expectedOutput = "\n\t1. Seleccionar juego\n" +
                "\t2. Ingresar saldo inicial del jugador\n" +
                "\t3. Consultar saldo del jugador\n" +
                "\t4. Consultar historico de resultados\n" +
                "\t0. Salir\n" +
                "\tIngrese la opcion : " +
                "\nIngrese el saldo inicial : "+
                "\n\t1. Seleccionar juego\n" +
                "\t2. Ingresar saldo inicial del jugador\n" +
                "\t3. Consultar saldo del jugador\n" +
                "\t4. Consultar historico de resultados\n" +
                "\t0. Salir\n" +
                "\tIngrese la opcion : ";
        String actualOutput = outputStreamCaptor.toString();
        assertEquals(expectedOutput, actualOutput );
    }
}
