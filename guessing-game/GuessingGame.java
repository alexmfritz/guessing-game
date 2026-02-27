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
    }

    public static void printIntro() {
        System.out.println("Integer unknown");
        System.out.println("Bound by zero and one hundred");
        System.out.println("Seek it with a guess");
        System.out.println();
    }

    public static void printStats(int totalGames, int totalGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Overall games = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/Games = %.fn%n", (double) totalGuesses / totalGames);
        System.out.println("Best game = " + bestGame);
    }
}
