public class GuessCheck {
    public static GuessResult checkGuess(int guess,int secretNumber){
        if(guess == secretNumber){
            return GuessResult.CORRECT;
        } else if (guess < secretNumber) {
            return GuessResult.LOW;
        }else {
            return GuessResult.HIGH;
        }
    }
}

