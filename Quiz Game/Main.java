import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[] questions = {
            "What does CPU stand for?",
            "Which language is used for web development?",
            "What is the main function of RAM?",
            "Which of these is an operating system?",
            "What does HTML stand for?"
        };

        String[][] options = {
            {"1. Central Processing Unit", "2. Computer Personal Unit", "3. Central Process Unit", "4. Control Processing Unit"},
            {"1. Python", "2. Java", "3. JavaScript", "4. C++"},
            {"1. Store permanent data", "2. Process graphics", "3. Run applications temporarily", "4. Control network traffic"},
            {"1. Microsoft Word", "2. Google Chrome", "3. Windows", "4. Adobe Photoshop"},
            {"1. Hyper Text Markup Language", "2. High Tech Modern Language", "3. Hyperlink and Text Markup Language", "4. Home Tool Markup Language"}
        };

        int[] answers = {1, 3, 3, 3, 1};
        int score = 0;
        int guess;

        Scanner scanner = new Scanner(System.in);

        System.out.println("*****************");
        System.out.println("JAVA  QUIZ  GAME");
        System.out.println("*****************");
        System.out.println();
        System.out.println();

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for(String option : options[i]) {
                System.out.println(option);
            }
            
            System.out.println();
            System.out.println("Enter your Guess : ");
            guess = scanner.nextInt();

            if (guess == answers[i]) {
                System.out.println("Correct Answer \n");
                score++;
            }
            else {
                System.out.println("Wrong Answer \n");
            }
    }

        System.out.println("Your Score is : " + score + " out of " + questions.length);

        scanner.close();
    }
}