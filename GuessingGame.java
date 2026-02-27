// Alex Fritz
// Programming Project #3 - Extra Credit
// CS& 141 - Frank Shang

// Import Java utilities (Scanner and Random classes)
import java.util.*;

public class GuessingGame {
    // create game constant for max range of random
    public static final int MAX = 100;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = MAX + 1;
        String response;

        printIntro();

        do {
            int currRoundGuesses = playOneGame(scanner, rand);
            totalGames++;
            totalGuesses += currRoundGuesses;
            bestGame = Math.min(bestGame, currRoundGuesses);

            System.out.print("Do you want to play again? ");
            response = scanner.next();
        } while (response.startsWith("y") || response.startsWith("Y"));

        System.out.println();
        printStats(totalGames, totalGuesses, bestGame);
    }

    public static void printIntro() {
        System.out.println("Integer unknown");
        System.out.println("Bound by one and one hundred");
        System.out.println("Seek it with a guess");
        System.out.println();
    }

    public static int playOneGame(Scanner scanner, Random rand) {
        int answer = rand.nextInt(MAX) + 1;

        System.out.println("I'm thinking of a number between 1 and " + MAX + "...");

        int totalGuesses = 0;
        int currGuess;

        do {
            System.out.println("Your guess? ");
            currGuess = scanner.nextInt();
            totalGuesses++;

            if (currGuess < answer) {
                System.out.println("It's higher.");
            } else if (currGuess > answer) {
                System.out.println("It's lower.");
            }
        } while (currGuess != answer);
        
        String message = totalGuesses == 1 ? "1 guess!" : totalGuesses + " guesses!";
        System.out.println("You got it right in " + message);

        return totalGuesses;
    }

    public static void printStats(int totalGames, int totalGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Total games = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/games = %.1f%n", (double) totalGuesses / totalGames);
        System.out.println("Best game = " + bestGame);
    }
}
