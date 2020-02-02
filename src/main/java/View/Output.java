package View;

import static View.Strings.*;
import static View.Strings.FIRSTORSECONDPROMPT;

public class Output {
    private static Output out = new Output();

    public static void welcome(){
        out.display(TILDE_BANNER + WELCOME);
    }

    public static void firstOrSecondPrompt(){
        out.display(EQUALSIGN_BANNER + FIRSTORSECONDPROMPT);
    }

    public static void initialPromptError(){
        out.display(ASTERISK_BANNER + INITIALPROMPTERROR);
    }

    private static void display (String message){
        System.out.print(message);
    }
}
