
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputHandler inputHandler = new ConsoleInputHandler(scanner);
        OutputHandler outputHandler = new ConsoleOutputHandler();

        outputHandler.displayMessage("Enter your name:");
        String playerName = inputHandler.getLine();
        Player player = new Player(playerName);

        NumberRange range = new NumberRange(1, 100);
        int maxGuesses = 0;
        while (true) {
            outputHandler.displayMessage("Enter the number of Guesses you want it to be( MUST BE GREATER THAN 0 !)");
            try {
                maxGuesses = inputHandler.getGuess();

                if (maxGuesses > 0) {
                    break;
                }

                outputHandler.displayMessage("Number of Guesses must be greater than 0.");

            }catch (InputMismatchException e){
                outputHandler.displayMessage("Invalid Output please enter a positive number.");
                inputHandler.getLine();
            }

        }

        boolean playAgain = true;

        while (playAgain) {
            NumberGenerator generator = new RandomNumberGenerator(range);
            Game game = new Game(player, generator, maxGuesses, inputHandler, outputHandler);
            player.incrementGamesPlayed();
            game.play();

            while (true) {
                outputHandler.displayMessage("Play again? (Yes/No): ");
                String playAgainInput = inputHandler.getLine().toLowerCase();

                if (playAgainInput.equals("yes") || playAgainInput.equals("y")) {
                    break;
                } else if (playAgainInput.equals("no") || playAgainInput.equals("n")) {
                    playAgain = false;
                    break;
                } else {
                    outputHandler.displayMessage("Invalid input. Please enter 'yes' or 'no.'");
                }
            }

        }

        //end game statistics
        outputHandler.displayMessage("Thanks for playing " + player.getName() + "!");
        outputHandler.displayMessage(" You Played " + player.getGamesPlayed() + " games and \n won -- " + player.getWins() + "  \n Lost -- " + player.getLost());
        scanner.close();

    }
}