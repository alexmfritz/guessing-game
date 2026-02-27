// Alex Fritz
// Programming Project #3 - Extra Credit
// CS& 141 - Frank Shang

// Import Java utilities (Scanner and Random classes)
import java.util.*;

public class GuessingGame {
    // create game constant for max range of random
    public static final int MAX = 100;

    // entry point for application
    public static void main(String[] args) {
        // introduce scanner and random to app
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();

        // declare variables to track games/guess stats and user response
        int totalGames = 0;
        int totalGuesses = 0;
        int bestGame = MAX + 1;
        String response;

        printIntro();

        // used do while instead of while because user the user needs to play at least one game before being prompted to play another
        // a while loop would potentially require calling playOneGame first outside loop and then again inside loop to keep it going
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

    // created function for intro text to clean up main method
    // prints the introductory haiku before starting game
    public static void printIntro() {
        System.out.println("Integer unknown");
        System.out.println("Bound by one and one hundred");
        System.out.println("Seek it with a guess");
        System.out.println();
    }

    // plays a single round of game 
    // the computer picks a random number and the player guesses, with feedback, until correct
    // the computer returns the number of guesses the user needed
    public static int playOneGame(Scanner scanner, Random rand) {
        int answer = rand.nextInt(MAX) + 1;

        System.out.println("I'm thinking of a number between 1 and " + MAX + "...");

        int totalGuesses = 0;
        int currGuess;

        // used do while instead of while because the user needs to make at least one guess in order to initiate game logic
        // a while loop would potentially require getting initial answer before loop and getting continuous next answers inside of loop
        do {
            System.out.println("Your guess? ");
            currGuess = scanner.nextInt();
            totalGuesses++;

            if (currGuess < answer) { // checking if lower than current guess
                System.out.println("It's higher.");
            } else if (currGuess > answer) { // checking if higher than current guess
                System.out.println("It's lower.");
            }
        } while (currGuess != answer);
        
        // used ternary to reduce repetition of if/else conditional logic to produce different message based on single/multiple guesses
        String message = totalGuesses == 1 ? "1 guess!" : totalGuesses + " guesses!";
        System.out.println("You got it right in " + message);

        return totalGuesses;
    }

    // print functionality for overall game results
    // used printf to format 1 decimal place in double
    // (double) used to typecast integer division into double
    public static void printStats(int totalGames, int totalGuesses, int bestGame) {
        System.out.println("Overall results:");
        System.out.println("Total games = " + totalGames);
        System.out.println("Total guesses = " + totalGuesses);
        System.out.printf("Guesses/games = %.1f%n", (double) totalGuesses / totalGames);
        System.out.println("Best game = " + bestGame);
    }
}
