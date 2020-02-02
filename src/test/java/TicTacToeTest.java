import Model.GameInitializer;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }
    //Citation for above code: https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println

    //Method naming convention: methodDescription_expectedInputOrState_expectedBehavior   https://www.petrikainulainen.net/programming/testing/writing-clean-tests-naming-matters/
    @Test
    void startMethodInMain_onFreshStartOrResetNoInput_DisplayWelcomeMessage(){
        String expectedOutput = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Welcome to TicTacToe on console!\n" +
                "===================================================\n" +
                "Would you like to go first or second?\n";
        TicTacToe.main(new String[0]);
        assertEquals(expectedOutput, outContent.toString());
    }
}
