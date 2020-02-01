import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TicTacToeTest {
    private final InputStream systemIn = System.in;
    private final PrintStream systemOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    //Method naming convention: methodDescription_expectedInputOrState_expectedBehavior   https://www.petrikainulainen.net/programming/testing/writing-clean-tests-naming-matters/
    @Test
    @DisplayName("Main Method")
    void startProgramMainMethod_noInput_displayWelcomeMessage(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        String expectedOutput = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Welcome to TicTacToe on console!\n" +
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n";

        TicTacToe.main(new String[0]);
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    @DisplayName("Start Method")
    void startMethodInMain_onFreshStartOrResetAskUserToGoFirstOrSecond_UserRepliesFirst(){

    }
}
