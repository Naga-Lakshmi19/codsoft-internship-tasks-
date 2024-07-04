import java.util.*;
class NumberGuessingGame {
    public int maxAttempts;
    public int score;
    public Random random;
    public Scanner scanner;
    public NumberGuessingGame(int maxAttempts) {
        this.maxAttempts = maxAttempts;
        this.score = 0;
        this.random = new Random();
        this.scanner = new Scanner(System.in);
    }
    public void playGame() {
        boolean playAgain;
        do {
            playRound();
            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);
        System.out.println("Thank you for playing! Your final score is: " + score);
    }
    public void playRound() {
        int randomNumber = random.nextInt(100) + 1;
        int attempts = 0;
        boolean guessedCorrectly = false;
        System.out.println("Guess the number between 1 and 100:");
        while (attempts < maxAttempts && !guessedCorrectly) {
            System.out.print("Enter your guess: ");
            int userGuess = scanner.nextInt();
            attempts++;
            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number correctly.");
                guessedCorrectly = true;
                score += (maxAttempts - attempts + 1);
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }
        if (!guessedCorrectly) {
            System.out.println("Sorry, you've used all attempts. The correct number was " + randomNumber);
        }
        System.out.println("Your current score is: " + score);
    }
}
public class NumberGame {
    public static void main(String[] args) {
        int maxAttempts = 10;
        NumberGuessingGame game = new NumberGuessingGame(maxAttempts);
        game.playGame();
    }
}