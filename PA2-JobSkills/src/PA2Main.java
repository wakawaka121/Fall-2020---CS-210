
/*
 * Author: Derek Tominaga
 * File: PA2Main.java
 * Description: This program will read a cleaned CSV file.
 * From the CSV data the job category and location will be
 * extracted into a HashMap where the keys are the categories
 * and the vlues will be a ArrayList of the cities
 * where the position is open.
 * Will print out information based on the command*/
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PA2Main {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> csvData = scanCSV(args[0]);
        HashMap<String, ArrayList<String>> catagoryLocations = jobSkillMap(
                csvData);
        if (args[1].equals("CATCOUNT")) {
            catagory(catagoryLocations);
        } else if (args[1].equals("LOCATIONS")) {
            location(catagoryLocations, args[2]);
        } else {
            System.out.println("Invalid Command");
        }
    }

    public static ArrayList<String> scanCSV(String file)
            /*
             * This method will take in a csv vile location to make a scanner
             * to create a list of strings, each string will contain
             * information about a particular position
             * file: is a string
             * return fileStrings which is an ArrayList of strings
             */
            throws FileNotFoundException {
        Scanner fileData = new Scanner(new File(file));
        ArrayList<String> fileStrings = new ArrayList<String>();
        while (fileData.hasNext()) {
            fileStrings.add(fileData.nextLine());
        }
        fileData.close();
        return fileStrings;
    }

    public static HashMap<String, ArrayList<String>> jobSkillMap(
            ArrayList<String> data) {
        /*
         * This method takes in a list of strings to create a HashMap where keys
         * are categories
         * and the values is a list of locations where a position is avaliabe
         * data: is an ArrayList of strings
         * returns catagoryLocationMap which is a HashMap
         */
        HashMap<String, ArrayList<String>> catagoryLocationMap = new HashMap<String, ArrayList<String>>();
        for (int line = 1; line < data.size(); line++) {
            // String lineArray = new ArrayList<String>();
            String[] lineArray = new String[data.get(line).split(",").length];
            lineArray = data.get(line).split(",");
            if (!catagoryLocationMap.containsKey(lineArray[2])) {
                catagoryLocationMap.put(lineArray[2], new ArrayList<String>());
                catagoryLocationMap.get(lineArray[2]).add(lineArray[3]);
            } else {
                catagoryLocationMap.get(lineArray[2]).add(lineArray[3]);
            }
         
        }
        return catagoryLocationMap;

    }

    public static void catagory(HashMap<String, ArrayList<String>> map) {
        /*
         * This method takes in a HashMap to print out for each category
         * how many positions (regardless of location) are open
         * map: is a HashMap
         */
        System.out.println("Number of positions for each category");
        System.out.println("-------------------------------------");
        List<String> sortedKeys = new ArrayList<String>(map.keySet());
        Collections.sort(sortedKeys);
        for (String word : sortedKeys) {
            System.out.println(word + ", " + map.get(word).size());
        }
    }

    public static void location(HashMap<String, ArrayList<String>> map,
            String category) {
        /*
         * This method takes in two parameters to print out a list of
         * locations with the number of positions avaliavbe for a particular
         * category
         * map: is a HashMap
         * category: is a string
         */
        System.out.println("LOCATIONS for category: " + category);
        System.out.println("-------------------------------------");
        if (map.containsKey(category)) {
            ArrayList<String> sortedValues = new ArrayList<String>();
            // will hold only unique locations
            for (String word : map.get(category)) {
                if (!sortedValues.contains(word)) {
                    sortedValues.add(word);
                }
            }
            Collections.sort(sortedValues);
            for (String word : sortedValues) {
            System.out.println(
                    word + ", "
                            + Collections.frequency(map.get(category), word));
        }
    } else {
        System.out.println("");
    }
    }
}

