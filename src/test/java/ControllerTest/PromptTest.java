package ControllerTest;

import Controller.Prompt;
import org.junit.Rule;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PromptTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Rule
    public final TextFromStandardInputStream systemInMock
            = emptyStandardInputStream();

    @Test
    void getUserResponseAndPromptObject_anyUserInputWithValidResponse_displayExpectedResponse(){
        char[] testAcceptedResponses = {'y', 'n'};
        char testBannerSymbol = '=';
        Prompt testPrompt = new Prompt ("Test prompt expecting an input of y or n", testAcceptedResponses, testBannerSymbol);

        String expectedOutput =
                "***************************************************" +
                        "Please respond correctly (first or second)\n" +
                        "===================================================\n" +
                        "Would you like to go first or second?\n";;

        systemInMock.provideLines("y");
        assertEquals(expectedOutput, outContent.toString());
    }

    void getUserResponseAndPromptObject_anyUserInputWithValidResponseButTypesWholeWord_displayExpectedResponse(){
        char[] testAcceptedResponses = {'y', 'n'};
        Prompt testPrompt = new Prompt ("Test prompt expecting an input of y or n", )

        String expectedOutput =
                "***************************************************" +
                        "Please respond correctly (first or second)\n" +
                        "===================================================\n" +
                        "Would you like to go first or second?\n";;

        systemInMock.provideLines("y");
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void getUserResponseAndPromptObject_anyUserInputWithInvalidResponse_displayExpectedResponse(){

    }
}
