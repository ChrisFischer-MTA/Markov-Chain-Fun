package markov.fun;

//import static java.lang.Math.random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Random;
import java.util.Scanner;

public class MarkovFun {

    public static void main(String[] args) {
        Random rand = new Random();
        boolean random = true;
        // Grab a scanner to take this input.
        Scanner stdin = new Scanner(System.in);
        String raw_input = "";
        while (!raw_input.contains("-1")) {
            raw_input += stdin.nextLine();
        }

        // Split up everything by spaces and throw into an array list.
        String[] wordArray = raw_input.split(" ");
        ArrayList<String> rawArrayConverted = new ArrayList(Arrays.asList(wordArray));
        ArrayList<word> masterWordList = new ArrayList();

        // Add new words :)
        int index;
        String currentWord;
        String pre;
        String aft;

        // Get Word.
        // Find if it's in master Array
        //  If it is, add to it's array the preceeding word and following word.
        //  if it it not, create a new word and add it to the master array.
        for (int j = 1; j < rawArrayConverted.size() - 1; j++) {
            // Index doubles as an int telling us where to find our word and as a boolean.
            index = -1;

            // Word Assignments
            currentWord = rawArrayConverted.get(j).toLowerCase().trim();
            pre = rawArrayConverted.get(j - 1).toLowerCase().trim();
            aft = rawArrayConverted.get(j + 1).toLowerCase().trim();

            for (int i = 0; i < masterWordList.size(); i++) {
                if (masterWordList.get(i).word.toLowerCase().trim().equals(currentWord)) {
                    index = i;
                }
            }
            if (index != -1) {
                masterWordList.get(index).afterword.add(aft);
                masterWordList.get(index).precursor.add(pre);
            } else {
                masterWordList.add(new word(pre, currentWord, aft));
            }

        }
        System.out.println(masterWordList.size());
        String word = "";
        if (!random) {
            word = masterWordList.get(1).word;
        }else{
            word = masterWordList.get(rand.nextInt(masterWordList.size())).word;
        }
        while (true) {
            for (int i = 0; i < 5; i++) {
                System.out.print(word + " ");
                word = mostCommon(word, masterWordList);
            }
            System.out.println();
        }
    }

    public static String mostCommon(String word, ArrayList<word> master) {
        for (int i = 0; i < master.size(); i++) {
            if (master.get(i).word.equals(word)) {
                return master.get(i).getAft();
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        throw new EmptyStackException();
       // return "failure";
    }
}
