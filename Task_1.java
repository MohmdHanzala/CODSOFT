import java.util.Random;
import java.util.Scanner;

public class Task_1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score = 0;
        boolean playAgain;
        
        do {
            int generatedNumber = random.nextInt(100) + 1;
            int maxAttempts = 10;
            int attempts = 0;
            boolean guessedCorrectly = false;
            
            System.out.println("Guess the number between 1 and 100:");
            
            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess: ");
                int userGuess = scanner.nextInt();
                attempts++;
                
                if (userGuess == generatedNumber) {
                    System.out.println("Congratulations! You guessed the correct number.");
                    guessedCorrectly = true;
                    score += (maxAttempts - attempts + 1); // Increase score based on remaining attempts
                } else if (userGuess > generatedNumber) {
                    System.out.println("Too high! Try again.");
                } else {
                    System.out.println("Too low! Try again.");
                }
            }
            
            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all attempts. The correct number was: " + generatedNumber);
            }
            
            System.out.println("Your current score is: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
            
        } while (playAgain);
        
        System.out.println("Thank you for playing! Your final score is: " + score);
        scanner.close();
    }
}