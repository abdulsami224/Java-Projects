import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int numOfDice;
        int total = 0;

        System.out.println("Enter the number of dice: ");
        numOfDice = scanner.nextInt();

        if (numOfDice > 0) {
            for(int i = 0; i < numOfDice; i++) {
                int roll = random.nextInt(1,7);
                printDie(roll);
                System.out.println("You rolled : " + roll);
                total += roll;
            }
            System.out.println("Total: " + total);
        }

        else {
            System.out.println("Invalid number of dice.");
        }

        scanner.close();
    }

    static void printDie(int roll) {
        String dice1 = """
                 -------
                |       |
                |   ●   |             
                |       |
                 -------
                """;
        String dice2 = """
                 -------
                | ●     |
                |       |             
                |     ● |
                 -------
                """;

        String dice3 = """
                 -------
                | ●     |
                |   ●   |             
                |     ● |
                 -------
                """;

        String dice4 = """
                 -------
                | ●   ● |
                |       |             
                | ●   ● |
                 -------
                """;
                
        String dice5 = """
                 -------
                | ●   ● |
                |   ●   |             
                | ●   ● |
                 -------
                """;
                
        String dice6 = """
                 -------
                | ●   ● |
                | ●   ● |             
                | ●   ● |
                 -------
                """;   

        switch (roll) {
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
            default -> System.out.println("Invalid roll.");
        }
    }

}