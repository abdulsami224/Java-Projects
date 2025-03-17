import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "word.txt";
        ArrayList<String> words = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String Line;
            while ((Line = reader.readLine()) != null) {
                words.add(Line.trim());
            }
        } 
        catch (FileNotFoundException e) {
            System.out.println("Could not find file.");
            return;
        }
        catch (IOException e) {
            System.out.println("Something went wrong.");
            return;
        }

        System.out.println("************************");
        System.out.println("WELCOME TO HANGMAN GAME!");
        System.out.println("************************");

        boolean playAgain = true;

        while (playAgain) {
            Random random = new Random();
            String word = words.get(random.nextInt(words.size()));
            ArrayList<Character> wordState = new ArrayList<>();
            int wrongGuesses = 0;

            for (int i = 0; i < word.length(); i++) {
                wordState.add('_');
            }

            while (wrongGuesses < 6) {
                System.out.println(getHangmanArt(wrongGuesses));
                System.out.print("Word: ");
                for (char c : wordState) {
                    System.out.print(c + " ");
                }
                System.out.println();

                System.out.println("Guess a letter: ");
                char guess = scanner.next().toLowerCase().charAt(0);

                if (word.indexOf(guess) >= 0) {
                    System.out.println("Correct Guess!");
                    for (int i = 0; i < word.length(); i++) {
                        if (word.charAt(i) == guess) {
                            wordState.set(i, guess);
                        }
                    }
                    if (!wordState.contains('_')) {
                        System.out.println(getHangmanArt(wrongGuesses));
                        System.out.println("YOU WIN!");
                        System.out.println("The word was: " + word);
                        break;
                    }
                } else {
                    wrongGuesses++;
                    System.out.println("Wrong Guess!");
                }
            }

            if (wrongGuesses >= 6) {
                System.out.println(getHangmanArt(wrongGuesses));
                System.out.println("GAME OVER");
                System.out.println("The word was: " + word);
            }

            System.out.println("\nDo you want to play again? (y/n)");
            char response = scanner.next().toLowerCase().charAt(0);
            playAgain = (response == 'y');
        }

        System.out.println("Thanks for playing! Goodbye!");
        scanner.close();
    }

    static String getHangmanArt(int wrongGuesses) {
        return switch (wrongGuesses) {
            case 0 -> """
                    


                      """;

            case 1 -> """
                       o
                       

                      """;
            
            case 2 -> """
                       o
                       |
                    
                      """;
            case 3 -> """
                       o
                      /|
                    
                      """;
            case 4 -> """
                       o
                      /|\\
                    
                      """;
            case 5 -> """
                       o
                      /|\\
                      /
                      """;
            case 6 -> """
                       o
                      /|\\
                      / \\
                      """;
            default -> "";
        };
    }
}
