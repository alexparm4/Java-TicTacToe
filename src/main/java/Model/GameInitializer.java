package Model;

import View.Output;

import java.util.Scanner;


public class GameInitializer {
    private static Scanner in = new Scanner(System.in);
    private static Token userToken = null;

    public static void startNewGame() {
        Output.welcome();
        userToken = tokenInitializer();
    }

    private static Token tokenInitializer() {
        boolean done = false;

        while (!done) {
            Output.firstOrSecondPrompt();
            String userInput = in.nextLine().toLowerCase();
            if (userInput == "first" || userInput == "f" || userInput == "1" || userInput == "1st" || userInput == "x") {
                userToken = new Token('x');
                done = true;
            } else if (userInput == "second" || userInput == "s" || userInput == "2" || userInput == "2nd" || userInput == "o") {
                userToken = new Token('o');
                done = true;
            } else {
                Output.initialPromptError();
            }
        }
        in.close();

        return userToken   ;
    }
}
