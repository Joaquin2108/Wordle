package GameLogic;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class WordSelector {
    private List<String> words;
    private String selectedWord;
    private static final boolean DEBUG = true;

    public WordSelector(){
        words = Collections.emptyList();
        choose();
    }

    private void choose(){
        words = readFile();
        Random random = new Random();
        int index = random.nextInt(words.size());
        if (DEBUG) index = 2960;
        selectedWord = words.get(index);
        if (DEBUG) System.out.println((index+1) + " " + selectedWord);
    }

    private List<String> readFile(){
        List<String> lines = Collections.emptyList();
        try{
            lines = Files.readAllLines(Path.of("/Users/joaquin/Wordle/src/main/java/GameLogic/Words.txt"));
        } catch (Exception e) {
            System.out.println("Problems with file !!!!");
        }
        return lines;
    }


    public String getSelectedWord() {
        return selectedWord;
    }
}
