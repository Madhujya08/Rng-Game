public class GameRound {
    private final int maxGuesses;
    private final int secretNumber;
    private int currentGuessCount;


    public GameRound (int maxGuesses,int secretNumber) {
        this.maxGuesses=maxGuesses;
        this.secretNumber=secretNumber;
        this.currentGuessCount = 0;
    }
    public GuessResult playRound (int guess) {
        currentGuessCount++;
        return GuessCheck.checkGuess(guess, secretNumber);
    }
    public boolean isGameOver () {
        return currentGuessCount >= maxGuesses;
    }
    public int getCurrentGuessCount () {
        return currentGuessCount;
    }
    public int getSecretNumber () {
        return secretNumber;
    }
}
