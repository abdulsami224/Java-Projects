import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        String[] choices = {"rock", "paper", "scissor"};
        String playerChoice;
        String computerChoice;
        String playAgain = "yes";

        do {       
            System.out.println("********************************");
            System.out.println("Welcome to Rock, Paper, Scissor!");
            System.out.println("********************************\n");

            System.out.print("Enter your choice: ");
            playerChoice = scanner.nextLine().toLowerCase();

            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissor")) {
                System.out.println("Invalid choice. Please enter 'rock', 'paper', or 'scissor'.");
                continue;
            }

            computerChoice = choices[random.nextInt(3)];
            System.out.println("Computer choice : " + computerChoice);

            if (playerChoice.equals(computerChoice)) {
                System.out.println("It's a tie!");
            }
            else if ((playerChoice.equals("rock") && computerChoice.equals("scissor")) || 
            (playerChoice.equals("paper") && computerChoice.equals("rock")) || 
            (playerChoice.equals("scissor") && computerChoice.equals("paper"))) {
                System.out.println("You win!\n");
            }
            else {
                System.out.println("You lose!\n");
            }

            System.out.println("Do you want to play again? (yes/no)");
            playAgain = scanner.nextLine().toLowerCase();
        } while (playAgain.equals("yes"));

        System.out.println("Thanks for playing!");
    }
}