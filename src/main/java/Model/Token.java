package Model;

public class Token {
    private static char tokenValue = 0;

    public Token (char receivedSignal){
        if (receivedSignal == 'x'){
            tokenValue = 'X';
        } else {
            tokenValue = 'O';
        }
    }
}
