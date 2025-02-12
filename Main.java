import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int maxNumber = 25;
        int randomNumber = rand.nextInt(maxNumber) + 1; // Ensure range is 1-25
        int userGuess;
        boolean ready;
        int guessesLeft = 3;

        System.out.println("Welcome to the number guesser! The computer has chosen a number between 1 and " + maxNumber);
        System.out.print("Are you ready? (true/false): ");

        if (scanner.hasNextBoolean()) {
            ready = scanner.nextBoolean();
            scanner.nextLine(); // Consume the newline

            if (ready) {
                while (guessesLeft > 0) {
                    System.out.print("Enter your guess: "); // Prompt inside the loop

                    if (scanner.hasNextInt()) {
                        userGuess = scanner.nextInt();

                        if (checkGuess(userGuess, randomNumber)) {
                            System.out.println("You're correct! Congrats!! 🎉");
                            break; // Exit loop when correct
                        } else {
                            guessesLeft--;
                            if (guessesLeft > 0) {
                                System.out.println("Incorrect! Try again. You have " + guessesLeft + " guesses left.");
                            } else {
                                System.out.println("You're out of guesses! The number was " + randomNumber + ". Please play again.");
                            }
                        }
                    } else {
                        System.out.println("Invalid input! Please enter a number.");
                        scanner.next(); // Discard invalid input
                    }
                }
            } else {
                System.out.println("Restart when ready!!");
            }
        } else {
            System.out.println("Invalid input! Please enter true or false.");
        }

        scanner.close();
    }

    public static boolean checkGuess(int userGuess, int randomNumber) {
        return userGuess == randomNumber;
    }
}
