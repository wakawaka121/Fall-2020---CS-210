
/*
 * Author: Derek Tominaga
 * File: PA12Main.java
 * Description: This file contains methods to find and print all permutations of combinations
 * of words for a given string. It takes command line arguments in form of [dict.txt, phrase, #].
 * The program will go through the words of the dictionary and find all possible words that can
 * be made from the phrase. After creating a list of possible words we can use a recursive method
 * to find all permutations of combinations of anagrams for a given phrase. Where the # is a word
 * limiter to bind the size of a set of anagrams. It contains methods to: create a word bank of all
 * words in the dictionary, a list of of all possible words that can be made from a phrase, and to
 * prints the anagram permutation combination.
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PA12Main {
    public static void main(String[] args) throws FileNotFoundException {
        // get the # passed in as an int value
        int wordLimit = Integer.parseInt(args[2]);
        // creates a new File from filename string, and creates scanner
        Scanner dictScanner = new Scanner(new File(args[0]));
        Set<String> dictBank = getDictBank(dictScanner);
        dictScanner.close();
        // using LetterInventory class to create letter inventory object
        // for a given phrase
        LetterInventory letterInventory = new LetterInventory(args[1]);
        System.out.println("Phrase to scramble: " + args[1] + "\n");
        ArrayList<String> possibleBank = getPossibleWords(letterInventory,
                dictBank);
        System.out.println(
                "All words found in " + args[1] + ":\n" + possibleBank + "\n");
        System.out.println("Anagrams for " + args[1] + ":");
        ArrayList<String> anagramList = new ArrayList<String>();
        printAnagramsLimit(letterInventory, possibleBank, anagramList,
                wordLimit);
    }

    /*
     * This function takes four parameters to create a ArrayList of anagrams,
     * and print them.
     * This is done using a recursive backtracking method and go through a list
     * of posssible
     * words that are possible to be created from the letters in a
     * letterInventory and explore
     * until all letters in the letterInventory is used. if world limit is != 0
     * then print
     * only anagram ArraList.size == worldLimit. If wordLimit is 0, print all
     * permutatons of combinations.
     * letterInventory: LetterInventory object that contains all the letters of
     * a given phrase
     * possibleBank: ArraList<String> of all words that can be made from letters
     * in the inventory
     * anagramList: ArrayList of anagrams found so far
     */
    private static void printAnagramsLimit(LetterInventory letterInventory,
            ArrayList<String> possibleBank, ArrayList<String> anagramList,
            int wordLimit) {
        if (letterInventory.isEmpty()) {
            if (wordLimit == 0) {
                System.out.println(anagramList);
            } else if (anagramList.size() == wordLimit) {
                System.out.println(anagramList);
            }
        } else {
            for (int word = 0; word < possibleBank.size(); word++) {
                // choose
                String choice = possibleBank.get(word);
                if (letterInventory.contains(choice)) {
                    anagramList.add(choice);
                    letterInventory.subtract(choice);
                    // explor
                    printAnagramsLimit(letterInventory, possibleBank,
                            anagramList, wordLimit);
                    // unchoose
                    anagramList.remove(choice);
                    letterInventory.add(choice);
                }
            }
        }
    }

    /*
     * This function takes two parameters to create a ArrayList<String> of all
     * possible words that can be made from a letterInventory. This is done by
     * once going through the words in a dictionary and and seeing if the
     * inventory has the letters to make the word. If so add to the possible
     * ArrayList.
     * letterInventory: is a LetterInventory object that contains the letters
     * for a given phrase
     * dictBank: is a TreeSet<String> of all the words form a passed in
     * dictionary
     * Return: arrayBank which is a ArrayList<String> of all possible words
     * from a dictionary that can be made from a given inventory.
     */
    private static ArrayList<String> getPossibleWords(
            LetterInventory letterInventory, Set<String> dictBank) {
        ArrayList<String> arrayBank = new ArrayList<String>();
        for (String word : dictBank) {
            if (letterInventory.contains(word)
                    && word.length() <= letterInventory.size()) {
                if (!arrayBank.contains(word)) {
                    arrayBank.add(word);
                }
            }

        }
        return arrayBank;

    }

    /*
     * This function takes one parameter to creates a TreeSet<String> of all the
     * words from a passed in dictionary file. This is done by looping through
     * the lines of a dictionary scanner and adding the words to the dictBank.
     * dictScanner: is a scanner object of the file passed in
     * Return: dictBank a TreeSet<String> of all the words in a dictionary, in
     * sorted order.
     */
    private static Set<String> getDictBank(Scanner dictScanner) {
        Set<String> dictBank = new TreeSet<String>();
        while (dictScanner.hasNext()) {
            String word = dictScanner.next();
            dictBank.add(word);
        }
        return dictBank;
    }
}
