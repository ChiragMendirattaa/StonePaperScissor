import java.util.Random;
import java.util.Scanner;

public class StonePaperScissor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int userWins = 0;
        int computerWins = 0;
        int rounds = 5;

        System.out.println("Welcome to Stone, Paper, Scissor Game!");
        System.out.println("Best of 3 wins out of 5 rounds.");

        for (int round = 1; round <= rounds; round++) {
            System.out.println("\nRound " + round);
            System.out.print("Enter your choice (0 for Stone, 1 for Paper, 2 for Scissor): ");
            int userChoice = scanner.nextInt();

            if (userChoice < 0 || userChoice > 2) {
                System.out.println("Invalid choice! Please enter 0, 1, or 2.");
                round--; // Repeat the same round
                continue;
            }

            int computerChoice = random.nextInt(3); // Randomly generate 0, 1, or 2

            System.out.println("Computer chose: " + getChoiceName(computerChoice));
            System.out.println("You chose: " + getChoiceName(userChoice));

            int result = determineWinner(userChoice, computerChoice);

            if (result == 1) {
                System.out.println("You won this round!");
                userWins++;
            } else if (result == -1) {
                System.out.println("Computer won this round!");
                computerWins++;
            } else {
                System.out.println("This round is a tie!");
            }

            System.out.println("Score: You " + userWins + " - " + computerWins + " Computer");

            // Check if a player has already won 3 rounds
            if (userWins >= 3 || computerWins >= 3) {
                break;
            }
        }

        System.out.println("\nGame Over!");
        if (userWins > computerWins) {
            System.out.println("Congratulations! You won the game!");
        } else if (computerWins > userWins) {
            System.out.println("Sorry! Computer won the game.");
        } else {
            System.out.println("The game is a tie!");
        }

        scanner.close();
    }

    // Helper method to convert choice number to name
    public static String getChoiceName(int choice) {
        switch (choice) {
            case 0:
                return "Stone";
            case 1:
                return "Paper";
            case 2:
                return "Scissor";
            default:
                return "Invalid";
        }
    }

    // Helper method to determine the winner of a round
    public static int determineWinner(int userChoice, int computerChoice) {
        if (userChoice == computerChoice) {
            return 0; // Tie
        }

        switch (userChoice) {
            case 0: // Stone
                return (computerChoice == 2) ? 1 : -1; // Stone > Scissor
            case 1: // Paper
                return (computerChoice == 0) ? 1 : -1; // Paper > Stone
            case 2: // Scissor
                return (computerChoice == 1) ? 1 : -1; // Scissor > Paper
            default:
                return 0; // Invalid
        }
    }
}