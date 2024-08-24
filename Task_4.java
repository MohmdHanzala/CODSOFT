import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Task_4 {
    private static int score = 0;
    private static int questionIndex = 0;
    private static boolean answered = false;

    public static void main(String[] args) {
        String[][] questions = {
            {"Question 1: What is the capital of France?", "A. Paris", "B. London", "C. Berlin", "D. Madrid"},
            {"Question 2: What is 2 + 2?", "A. 3", "B. 4", "C. 5", "D. 6"},
            {"Question 3: What is the largest planet in our solar system?", "A. Earth", "B. Mars", "C. Jupiter", "D. Saturn"},
            {"Question 4: Who wrote 'To Kill a Mockingbird'?", "A. Harper Lee", "B. J.K. Rowling", "C. Ernest Hemingway", "D. Mark Twain"},
            {"Question 5: What is the chemical symbol for water?", "A. H2O", "B. O2", "C. CO2", "D. NaCl"},
            {"Question 6: What is the speed of light?", "A. 300,000 km/s", "B. 150,000 km/s", "C. 450,000 km/s", "D. 600,000 km/s"},
            {"Question 7: Who painted the Mona Lisa?", "A. Vincent van Gogh", "B. Pablo Picasso", "C. Leonardo da Vinci", "D. Claude Monet"}
        };
        
        char[] answers = {'A', 'B', 'C', 'A', 'A', 'A', 'C'}; // Correct answers for each question
        
        try (Scanner scanner = new Scanner(System.in)) {
            for (questionIndex = 0; questionIndex < questions.length; questionIndex++) {
                answered = false;
                System.out.println(questions[questionIndex][0]); // Displaying Question
                
                for (int i = 1; i <= 4; i++) {
                    System.out.println(questions[questionIndex][i]); // Displaying Options
                }
                
                Timer timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (!answered) {
                            System.out.println("Time's up!");
                            nextQuestion();
                        }
                    }
                }, 30000); // Set timer for 30 seconds
                
                char response = scanner.nextLine().charAt(0);
                
                if (response == answers[questionIndex]) { 
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect.");
                }
                
                answered = true;
                timer.cancel(); 
            }
        }
        
        System.out.println("Quiz Over!");
        System.out.println("Your score: " + score + "/" + questions.length);
    }
    
    private static void nextQuestion() {
        questionIndex++;
        answered = true;
    }
}