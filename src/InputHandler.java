import java.util.InputMismatchException;

public interface InputHandler {
    int getGuess() throws InputMismatchException;
    String getLine();
}
