import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleInputHandler implements InputHandler {
    private final Scanner scanner;

    public ConsoleInputHandler(Scanner scanner){
        this.scanner= scanner;
    }
    @Override
    public int getGuess() throws InputMismatchException {
        int guess = scanner.nextInt();
        scanner.nextLine();
        return guess;
    }
    @Override
    public String getLine(){
        return scanner.nextLine();
    }
}
