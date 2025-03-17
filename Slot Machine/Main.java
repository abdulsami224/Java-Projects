import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int balance = 100;
        int bet;
        int payout;
        String[] row;
        String playAgain;

        System.out.println("**************************");
        System.out.println("  Welcome to Java Slots!  ");
        System.out.println("Symbols: \"A\" \"B\" \"C\" \"D\" \"E\"");
        System.out.println("**************************");
        
        while (balance > 0) {
            System.out.println("Current Balance: $" + balance);
            System.out.println("Please place your bet: ");
            bet = scanner.nextInt();
            scanner.nextLine();

            if (bet > balance) {
                System.out.println("Insufficient funds!");  
                continue;
            }
            else if (bet <= 0) {
                System.out.println("Please enter a positive value!");
                continue;
            }
            else {
                balance -= bet;
                System.out.println("$" + balance);
            }

            System.out.println("Spinning...");
            row = spinRow();
            printRow(row);
            payout = getPayout(row, bet);

            if (payout > 0) {
                System.out.println("You won $" + payout);
                balance += payout;
            }
            else {
                System.out.println("Sorry, you lost this round.\n");
            }

            System.out.println("Do you want to play again? (y/n)");
            playAgain = scanner.nextLine().toLowerCase();

            if (!playAgain.equals("y")) {
                break;
            }
        }
        System.out.println("GAME OVER! Your final balance is $" + balance);

        scanner.close();
    }

    static String[] spinRow() {

        String[] symbols = {"A", "B", "C", "D", "E"};
        String[] row = new String[3];
        Random random = new Random();

        for (int i = 0; i < 3; i++) {
            row[i] = symbols[random.nextInt(symbols.length)];
        }

        return row;
    }

    static void printRow(String[] row) {
        System.out.println("********************");
        System.out.println(" " + String.join(" | ", row));
        System.out.println("********************");
    }

    static int getPayout(String[] row, int bet) {

        if (row[0].equals(row[1]) && row[1].equals(row[2])) {
            return switch(row[0]) {
                case "A" -> bet * 3;
                case "B" -> bet * 4;
                case "C" -> bet * 5;
                case "D" -> bet * 10;
                case "E" -> bet * 20;
                default -> 0;
            };
        }

        else if (row[0].equals(row[1])) {
            return switch(row[0]) {
                case "A" -> bet * 2;
                case "B" -> bet * 3;
                case "C" -> bet * 4;
                case "D" -> bet * 5;
                case "E" -> bet * 10;
                default -> 0;
            };
        }

        else if (row[1].equals(row[2])) {
            return switch(row[1]) {
                case "A" -> bet * 2;
                case "B" -> bet * 3;
                case "C" -> bet * 4;
                case "D" -> bet * 5;
                case "E" -> bet * 10;
                default -> 0;
            };
        }

        return 0;
    }
}