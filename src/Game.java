import java.util.Arrays;
import java.util.Scanner;

public class Game {

    static String movie = MovieTitles.randomMovie().toLowerCase();
    static int turns = 10;
    static char[] winCondition = movie.toCharArray();

    private static char[] showLetter(char[] hiddenTitle, char userGuessChar) {
        //logic for converting a * into a the proper letter
        int index = movie.indexOf(userGuessChar);
        while (index >= 0) {
            hiddenTitle[index] = userGuessChar;
            index = movie.indexOf(userGuessChar, index + 1);
        }
        return hiddenTitle;
    }

    private static char[] displayMovie(String movie) {
        //converts the hidden movie title into a charArray so it can easily be replaced
        String hideTittle = movie.replaceAll("\\w", "*");
        char[] hiddenTitle = hideTittle.toCharArray();
        return hiddenTitle;
    }

    public static void help() {
        //help message in case a user gets stuck
        System.out.println("The rules are simple You will be shown a Movie Title with all letters changed to a *");
        System.out.println("You will then have 10 tries to guess all the letters in the title.");
        System.out.println("If you guess incorrectly it will count against your turns.  If you run out of turns you LOOSE.");
        System.out.println("if at any time you need help enter \"-h\" to display this message again.");
    }

    private static void startMessage() {
        //start message
        System.out.println("Lets play a game called Guess The Movie Title");
        System.out.println("The rules are simple You will be shown a Movie Title with all letters changed to a *");
        System.out.println("You will then have 10 tries to guess all the letters in the title.");
        System.out.println("If you guess incorrectly it will count against your turns.  If you run out of turns you LOOSE.");
        System.out.println("Are you ready to play? Type \"start\" and press the enter button to start if at any time you need help enter \"-h\" to display this message again.");
        Scanner input = new Scanner(System.in);
        String gameStart = input.nextLine();
        String gameStartLower = gameStart.toLowerCase();
        //makes sure that only start is entered if not then it will prompt the user again.
        if (gameStartLower.contains("start")) {

        } else {
            startMessage();
        }
    }

    public static void main (String[]args){
        //System.out.println(movie);
        startMessage();
        char[] hiddenTitle = displayMovie(movie);
        //an array that stores all of the incorrect user guesses
        char[] userGuesses = new char[11];
        //keeps the game on a loop
        while (turns > 0) {
            //defines a win condition if all the letters are revealed in hiddenTitle
            boolean win = Arrays.equals(winCondition, hiddenTitle);
            //displays the number of turns as well as the movie title and missed letters
            System.out.print("You have " + turns + " guesses left. The Title is ");
            for (int i = 0; i < movie.length(); i++) {
                System.out.print(hiddenTitle[i]);
            }
            System.out.print(" . Your guesses are ");
            for (int z = turns; z < 10; z++) {
                System.out.print(" , " + userGuesses[z]);
            }
            System.out.println(" . Please enter a letter.");
            //if a user has won
            if (win) {
                System.out.println("You WIN!!!!!!");
                break;
            }
            //takes in the input and converts it to all lowercase and then only the first character entered
            Scanner input = new Scanner(System.in);
            String userGuessString = input.next();
            String userGuessLower = userGuessString.toLowerCase();
            char userGuessChar = userGuessLower.charAt(0);
            //if the user needs help
            if (userGuessString.contains("-h")) {
                help();
            } else if (movie.indexOf(userGuessChar) >= 0) {
                showLetter(hiddenTitle, userGuessChar);
                //takes a wrong guess and stores it into another array then subtracts from the turns
            } else {
                turns--;
                userGuesses[turns] = userGuessChar;
            }
        }
        //if you run out of moves
        if (turns == 0) {
            System.out.println("You loose!!!");
            System.out.println("The movie title is " + movie);
        }
    }
}

