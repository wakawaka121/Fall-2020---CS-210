import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/* 
 Author: Derek Tominaga
 File: WordSearch.java
 Description: This program contains methods and a main that will
 take in a text file where first two lines dictate rows and cols. all other lines
 go to dictate what the word grid will look like. The program 
 will then scan the rows and cols for substrings of length 3 or
 more. If the substring is in the dictionary it will add it to
 */

public class WordSearch {
    /*
     * This is how you declare constants in Java. You can now type
     * 'MIN_WORD_LENGTH' anywhere you want to refer to it.
     */
    private static final int MIN_WORD_LENGTH = 3;

    public static ArrayList<String> generateDict(String file)
            throws FileNotFoundException {
        /*
         * This method takes in a file name. From the file name we make a
         * scanner that will go through the lines of the file and generate
         * an ArrayList<Strings> that contains all the words that are to be
         * searched for in the word search
         * returns dictionarySet which is an ArrayList of the words
         */
        Scanner dictionary = new Scanner(new File(file));
        ArrayList<String> dictionarySet = new ArrayList<String>();
        while (dictionary.hasNext()) {
            dictionarySet.add(dictionary.nextLine().toLowerCase());
        }
        return dictionarySet;
    }

    public static String[][] generateGrid(String file)
            throws FileNotFoundException {
        /*
         * This method takes one argument that is a file name/location
         * a scanner will go through the lines of the file and extract
         * information
         * about the letter grid to be used in the word search
         * return grid an String[][] array
         */
        Scanner gridDef = new Scanner(new File(file));
        int line = 0;
        int height = Integer.valueOf(gridDef.nextLine());// height of grid
        int width = Integer.valueOf(gridDef.nextLine());// width of grid
        String[][] grid = new String[height][width];
        while (gridDef.hasNext()) {
            grid[line] = gridDef.nextLine().split(" ");
            line++;
        }
        return grid;

    }

    public static ArrayList<String> horizontalWord(ArrayList<String> dictionary,
            String[][] grid) {
        /*
         * This method will take two arguments a dictionary ArrayList and a
         * String[][]
         * array grid representing the word search grid
         * the method will search left to right and if the words is at least
         * 3 letters long and in exisits in the dictionary it is added to a list
         * of
         * found words.
         * horizontalWord is an ArrayList<String> of the words found.
         * returns horizontalWord
         */
        ArrayList<String> horizontalWord = new ArrayList<String>();
        int height = grid.length;
        int width = grid[0].length;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int curRow = y;
                int curCol = x;
                String stringSoFar = "";
                while (curRow < height && curCol < width) {
                    stringSoFar = stringSoFar + grid[curRow][curCol];
                    curCol++;
                    if (stringSoFar.length() >= MIN_WORD_LENGTH
                            && dictionary.contains(stringSoFar.toLowerCase())) {
                        horizontalWord.add(stringSoFar.toLowerCase());
                    }
                }
            }
        }
        return horizontalWord;

    }

    public static ArrayList<String> verticleWords(ArrayList<String> dictionary,
            String[][] grid) {
        /*
         * This method will take in search a letter grid from top to bottom
         * to find substrings of the letters, if the substrig is a word and is
         * in the dictionary ArrayList then it will add the word to a
         * found words list called verticleWords
         * returns verticleWords.
         * 
         */
        ArrayList<String> verticleWords = new ArrayList<String>();
        int height = grid.length;
        int width = grid[0].length;
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                int curRow = x;
                int curCol = y;
                String stringSoFar = "";
                while (curRow < height && curCol < width) {
                    stringSoFar = stringSoFar + grid[curRow][curCol];
                    curRow++;
                    if (stringSoFar.length() >= MIN_WORD_LENGTH
                            && dictionary.contains(stringSoFar.toLowerCase())) {
                        verticleWords.add(stringSoFar.toLowerCase());
                    }
                }
            }
        }
        return verticleWords;

    }

    public static String[][] reverseRows(String[][] grid) {
        /*
         * This method will take in the letter grid and reverse
         * row order in-order to use same left to right search method
         * to find words.
         * returns an String[][] array.
         */
        int height = grid.length;
        int width = grid[0].length;
        int count = 0;
        String[][] reversedRows = new String[height][width];
        while (count < height) {
            String[] newRow = new String[width];
            for (int element = 0; element < width; element++) {
                newRow[element] = grid[count][width - 1 - element];
            }
            reversedRows[count] = newRow;
            count++;
        }
        // for (int index = 0; index < height; index++) {
        // for (int element = 0; element < width; element++) {
        // // System.out.println(grid[index][element]);
        // newRow[element] = grid[index][(width - 1) - element];
        // }
        // reversedRows[index] = newRow;
        // } THIS WAS PREVIOUS VERSION OF CODE THAT I WAS WORKING WITH BUT KEPT
        // HAVING AN ERROR
        return reversedRows;

    }

    public static String[][] reverseCols(String[][] grid) {
        /*
         * This method takes in a letter grid to reveres the order
         * of the inner list which represent the rows of the grid. Doing
         * this allows the use of the same verticle word search algorithm.
         * returns reverseCols, an String[][] array.
         */
        int height = grid.length;
        int width = grid[0].length;
        String[][] reverseCols = new String[height][width];
        for (int row = 0; row < height; row++) {
            reverseCols[row] = grid[height - 1 - row];
        }
        return reverseCols;

    }

    public static void main(String[] args) throws FileNotFoundException {
        // Remember, to access command-line arguments, you use args[0],
        // args[1],...
        // See CommandLine.java and Stdin.java in the Class Examples github for
        // examples.
        ArrayList<String> dictionarySet = generateDict(args[0]);
        String[][] grid = generateGrid(args[1]);
        String[][] reverseRowGrid = reverseRows(grid);
        String[][] reverseColGrid = reverseCols(grid);
        ArrayList<String> lToRWords = horizontalWord(dictionarySet, grid);
        ArrayList<String> rToLWords = horizontalWord(dictionarySet,
                reverseRowGrid);
        ArrayList<String> topBottom = verticleWords(dictionarySet, grid);
        ArrayList<String> bottomTop = verticleWords(dictionarySet,
                reverseColGrid);
        ArrayList<String> foundWords = new ArrayList<String>();
        foundWords.addAll(lToRWords);
        foundWords.addAll(rToLWords);
        foundWords.addAll(topBottom);
        foundWords.addAll(bottomTop);
        for (String word : foundWords) {
            System.out.println(word);
        }
    }
}


