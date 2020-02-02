package ModelTest;

import Model.GameInitializer;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameInitializerTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

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

    @Test
    void gameInitializerStartNewGame_onFreshStartOrResetNoInput_NoResponse() {
        String expectedOutput =
                "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n" +
                "Welcome to TicTacToe on console!\n" +
                "===================================================\n" +
                "Would you like to go first or second?\n";
        GameInitializer.startNewGame();
        assertEquals(expectedOutput, outContent.toString());
    }

    //Simulated input code citation: https://stackoverflow.com/questions/6415728/junit-testing-with-simulated-user-input
    @Test
    void gameInitializerStartNewGame_onFreshStartOrResetFirstReply_displayBoardAndAskForFirstMove(){
        String expectedOutput =
                "XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxX\n" +
                " -  ||  -  ||  - \n" +
                "====||=====||====\n" +
                " -  ||  -  ||  - \n" +
                "====||=====||====\n" +
                " -  ||  -  ||  - \n" +
                "XxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxXxX\n" +
                "Enter the row, column for your move:";

        systemInMock.provideLines("first");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void gameInitializerStartNewGame_onFreshStartOrResetSecondReply_displayBoardWithComputerMoveAndAskForFirstMove(){
        String expectedOutput =
                "OoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoO\n" +
                        " X  ||  -  ||  - \n" +
                        "====||=====||====\n" +
                        " -  ||  -  ||  - \n" +
                        "====||=====||====\n" +
                        " -  ||  -  ||  - \n" +
                        "OoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoOoO\n" +
                        "Enter the row, column for your move:";

        systemInMock.provideLines("2");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void gameInitializerStartNewGame_onFreshStartOrResetWrongReply_errorMessageAndAskAgain(){
        String expectedOutput =
                "***************************************************" +
                        "Please respond correctly (first or second)\n" +
                        "===================================================\n" +
                        "Would you like to go first or second?\n";;

        systemInMock.provideLines("y");
        assertEquals(expectedOutput, outContent.toString());
    }
}
