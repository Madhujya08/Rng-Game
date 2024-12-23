import java.util.InputMismatchException;

public class Game {
    private final Player player;
    private final NumberGenerator numberGenerator;
    private final int maxGuesses;
    private final InputHandler inputHandler;
    private final OutputHandler outputHandler;


    public Game (Player player,NumberGenerator numberGenerator, int maxGuess,InputHandler inputHandler,OutputHandler outputHandler) {
        this.player= player;
        this.numberGenerator = numberGenerator;
        this.maxGuesses = maxGuess;
        this.inputHandler = inputHandler;
        this.outputHandler = outputHandler;
    }

    public void play () {
        GameRound round = new GameRound(maxGuesses,numberGenerator.generate());
        outputHandler.displayMessage("Welcome to the Number Guessing Game,"+ player.getName()+" !");
        NumberRange range = numberGenerator.getRange();
        outputHandler.displayMessage("I've chosen number between " + range.getMin() +" and "+ range.getMax() + ".");
        outputHandler.displayMessage("You have "+ maxGuesses +" tries to guess it");

        while (!round.isGameOver()) {
            try {
                int guess = inputHandler.getGuess();
                GuessResult result = round.playRound(guess);

                if (result == GuessResult.CORRECT) {
                    outputHandler.displayMessage("Congratulations " + player.getName() +"! you guessed the number in " + round.getCurrentGuessCount() +" tries.");
                    player.incrementWins();
                    return;
                }

                outputHandler.displayMessage(result == GuessResult.LOW ? "Your Guess is Low!" : "Your Guess is High!");

                if (round.isGameOver()) {
                    break;
                }
            } catch (InputMismatchException e) {
                outputHandler.displayMessage("Invalid input. Please enter a Number.");
            }
        }

        outputHandler.displayMessage("You ran out of guesses, " + player.getName() + " The number was " + round.getSecretNumber() + ".");
        player.incrementLost();

    }
}

