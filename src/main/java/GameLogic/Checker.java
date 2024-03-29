package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class Checker {

    protected ArrayList<Character> containedLetters;
    public char[] correctLetters;
    private String answer;

    private static final boolean DEBUG = false;

    public Checker(String answer){
         this.answer = answer;
         correctLetters = new char[]{'-', '-', '-', '-', '-'};
         containedLetters = new ArrayList<>();

    }

    protected boolean checkGuess(char[] guess, char[] answer){
        for (int i = 0; i < guess.length; i++){
            if (DEBUG) System.out.println("guess: " + guess[i] + "answer: " + answer[i]);
            if (guess[i] == answer[i]) continue;
            else return false;
        }
        return true;
    }
    protected void checkCorrectLetters(char[] guessAsArray, char[] answerAsArray) {
        for (int i = 0; i < answerAsArray.length; i++) {
            if (guessAsArray[i] == answerAsArray[i]) {
                correctLetters[i] = guessAsArray[i];
            }
            else{
                if (correctLetters[i] != '-') continue;
            }
            if (guessAsArray[i] == answerAsArray[i] && containedLetters.contains(guessAsArray[i])) {
                try {
                    System.out.println("Inside try before remove " + containedLetters);
                    containedLetters.remove(i);
                    System.out.println("Inside try after remove " + containedLetters);
                }
                catch (RuntimeException e){
                    System.out.println("Inside catch " + containedLetters);
                    containedLetters = new ArrayList<>();
                }
            }
        }
    }

    protected void checkContainedLetters(char[] guessAsArray, char[] answerAsArray){
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                if (i == j) continue;
                else {
                    if (guessAsArray[i] == answerAsArray[j]) {
                        System.out.println("The letter " + guessAsArray[i] + i +  " should be in contain");
                        if (!containedLetters.contains(guessAsArray[i])){
                            System.out.println("We add the new letter ");
                            containedLetters.add(guessAsArray[i]);
                            System.out.println(containedLetters + " #Contained letters");
                        }
                        else break;
                    }
                }
            }
        }
    }
}
