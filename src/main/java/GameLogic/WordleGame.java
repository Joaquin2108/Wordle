package GameLogic;

import java.lang.annotation.Documented;
import java.util.ArrayList;
import java.util.Scanner;

public class WordleGame {
    private String answer;
    private String guess;
    private boolean wordWasGuessed = false;
    private int guessCounter = 0;
    private char[] answerAsArray;
    private char[] guessAsArray;




    private static final boolean DEBUG = false;
    private static final int MAX_GUESSES = 5;

    /*
    I NEED TO REFACTOR THIS CLASS !!!!!!!
     */
    public WordleGame(){
        //Player player = new Player(name);
        this.answer = null;
    }
    public static void main() {
        WordleGame game = new WordleGame();
        Checker checker = new Checker(game.answer);
        WordSelector wordSelector= new WordSelector();
        if (game.answer == null) game.answer = wordSelector.getSelectedWord();
        else if (DEBUG)System.out.println("Something is wrong");

        if (DEBUG) System.out.println(game.answer);
        game.answerAsArray = game.wordToArray(game.answer);

        //While the word hasn't been guessed
        while (!game.wordWasGuessed){

            //If we take more than  limit of guesses then break
            if (game.guessCounter >= MAX_GUESSES) break;

            //Input word
            Scanner kb = new Scanner(System.in);
            System.out.println("Guess a 5 letter word: ");
            game.guess = kb.next();

            //Cast to array
            try {
                game.guessAsArray = game.wordToArray(game.guess);
            } catch (StringIndexOutOfBoundsException e) {
                System.out.println("Guess was not 5 letters long");

            }
            //Check if guess and answer are the same
            if (game.guessAsArray == null || game.answerAsArray == null) continue;
            else {
                game.wordWasGuessed = checker.checkGuess(game.guessAsArray, game.answerAsArray);
                //Increase guess counter
                game.guessCounter++;
                checker.checkContainedLetters(game.guessAsArray, game.answerAsArray);
                checker.checkCorrectLetters(game.guessAsArray, game.answerAsArray);

            }
            //Letters that are the same but not in the correct position
            System.out.println("  ---  Answer contains letters: " + String.valueOf(checker.containedLetters));
            System.out.println("  ***  Correct letter so far: " + String.valueOf(checker.correctLetters));
            System.out.println("  ###   Guesses used: " + game.guessCounter);

            game.guessAsArray = null;
        }

    }

    private char[] wordToArray(String word) {
        char[] array = new char[5];
        for (int i = 0; i< array.length; i++){
            if (word.length() != 5) new StringIndexOutOfBoundsException();
            array[i] = word.charAt(i);
            if (DEBUG)System.out.println(array[i]);
        }
        return array;
    }

}
