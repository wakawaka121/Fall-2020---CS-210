/*
 * Author: Derek Tominaga
 * File: PA11Main.java
 * Description: This program takes a command line argument, a filename.mtx COMMAND.
 * getDGraph function will take a passed in file and process it to create a DGraph object. 
 * Based on COMMAND the function assoiciatd with that COMMAND will be executed.
 * HERUISTIC: will call the heuristic function to find a path for the DGraph.
 * BACKTRACK: will call the backtracking function to find the shortest path for the DGraph.
 * MINE: will call my method, based on the backtracking method to find the shortes path, with improved
 * time complexity.
 * TIME: will call the time method to get a timing of the different algorithms. */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*This main function takes in a command line argument that contains a filename and
 * a COMMAND. 
 * This is done by creating a DGraph object by based on the information in the file.mtx.
 * Create a Trip object called path and then execute the COMMAND on the trip. 
 * The first city added to the path, and the path will be passed into
 * the heuristic, backtracking and my algorithms.
 * Based on COMMAND the function associated with that COMMAND will be executed.
 * HERUISTIC: will call the heuristic function to find a path for the DGraph.
 * BACKTRACK: will call the backtracking function to find the shortest path for the DGraph.
 * MINE: will call my method, based on the backtracking method to find the shortest path, with improved
 * time complexity.
 * TIME: will call the time method to get a timing of the different algorithms.  */
public class PA11Main {
    public static void main(String[] args) throws IOException {
        DGraph graph = getDGraph(args[0]);
        String command = args[1];
        Trip path = new Trip(graph.getNumNodes());
        path.chooseNextCity(1);
        if (command.equals("HERUISTIC")) {
            heuristicMethod(graph, path);
            System.out.println(path.toString(graph));
        } else if (command.equals("BACKTRACK")) {
            Trip minPath = new Trip(graph.getNumNodes());
            backtrackingMethod(graph, path, minPath);
            System.out.println(minPath.toString(graph));
        } else if (command.equals("MINE")) {
            Trip minPath = new Trip(graph.getNumNodes());
            myMethod(graph, path, minPath);
            System.out.println(path.toString(graph));
        } else if (command.equals("TIME")) {
            for (int times = 0; times < 5; times++) {
                time(graph);
                System.out.println();
            }
        }
    }

    /*
     * This function takes one parameter a DGraph, and will run and time
     * each of the algorithms and print out the results in the form of
     * cost of the path, and the time it took in milliseconds to find
     * the path based on the algorithm
     * It will be in the form of :
     * heuristic: cost = double, #milliseconds
     * mine: cost = double, #milliseconds
     * backtrack: cost = double, #milliseconds
     */
    public static void time(DGraph graph) {
        Trip heuristicPath = new Trip(graph.getNumNodes());
        heuristicPath.chooseNextCity(1);
        Trip myPath = new Trip(graph.getNumNodes());
        myPath.chooseNextCity(1);
        Trip recursivePath = new Trip(graph.getNumNodes());
        recursivePath.chooseNextCity(1);
        Trip minPath = new Trip(graph.getNumNodes());
        Trip myMinPath = new Trip(graph.getNumNodes());
        long startTime = System.nanoTime();
        heuristicMethod(graph, heuristicPath);
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 10000000;
        System.out.println("heuristic: cost = " + heuristicPath.tripCost(graph)
                + ", " + duration + " milliseconds");
        startTime = System.nanoTime();
        myMethod(graph, myPath, myMinPath);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000000;
        System.out.println("mine: cost = " + myMinPath.tripCost(graph) + ", "
                + duration + " milliseconds");
        startTime = System.nanoTime();
        backtrackingMethod(graph, recursivePath, minPath);
        endTime = System.nanoTime();
        duration = (endTime - startTime) / 10000000;
        System.out.println("backtrack: cost = " + minPath.tripCost(graph)
                + ", " + duration + " milliseconds");

    }

    /*
     * This function takes 3 parameters to perform a backtracking methods to
     * find the
     * the shortest path through all the nodes. This done by finding all
     * possible paths through
     * the nodes, and saving the path with the lowest cost( weight/distance)
     * between the nodes.
     * and saving them to minPath. In order to optimize the decisions, if the
     * cost of the
     * path so far is greater than current minPath, abandon that node and
     * backtrack to find
     * a different possible path. To further optimize, once a city is added to
     * path so far, check to see
     * if path sofar is with in 30% of minPath, if so abandon that path and
     * unchoose.
     * graph: is a DGraph object that represent the nodes and their connections.
     * path: is a Trip object that represents a path so far through all the
     * nodes
     * minPath: is a Trip object that represents the shortest(weight) path
     * through all the nodes.
     */
    public static void myMethod(DGraph graph, Trip path, Trip minPath) {
        if (path.citiesLeft().isEmpty()) {
            if (path.tripCost(graph) < minPath.tripCost(graph)) {
                minPath.copyOtherIntoSelf(path);
                return;
            }
        } else if (path.tripCost(graph) <= minPath.tripCost(graph)) {
            for (Integer city : path.citiesLeft()) {
                path.chooseNextCity(city);
                // checks to see if path so far is with in 30% of minPath, to
                // fined a
                // more optimal path.
                if (path.tripCost(graph) < minPath.tripCost(graph) * (.7)) {
                    backtrackingMethod(graph, path, minPath);
                }
                path.unchooseLastCity();
            }
        }
    }

    /*
     * This function takes 3 parameters to perform a backtracking methods to
     * find the
     * the shortest path through all the nodes. This done by finding all
     * possible paths through
     * the nodes, and saving the path with the lowest cost( weight/distance)
     * between the nodes.
     * and saving them to minPath. This is done by find all the possible paths
     * by selecting a city, recursing with the modified path so far, and then
     * unchoosing the city.
     * In order to optimize the decisions, if the
     * cost of the
     * path so far is greater than current minPath, abandon that node and
     * backtrack to find a different possible path.
     * graph: is a DGraph object that represent the nodes and their connections.
     * path: is a Trip object that represents a path so far through all the
     * nodes
     * minPath: is a Trip object that represents the shortest(weight) path
     * through all the nodes.
     */
    public static void backtrackingMethod(DGraph graph, Trip path,
            Trip minPath) {
        if (path.citiesLeft().isEmpty()) {
            if (path.tripCost(graph) < minPath.tripCost(graph)) {
                minPath.copyOtherIntoSelf(path);
                return;
            }
        }
        else if (path.tripCost(graph) <= minPath.tripCost(graph)) {
                for (Integer city : path.citiesLeft()) {
                    path.chooseNextCity(city);
                    backtrackingMethod(graph, path, minPath);
                    path.unchooseLastCity();
                }
            }
        }

        /*
         * This function takes two parameters to find the simplest path through
         * all the nodes of a
         * DGraph. This is done by looking through the neighbors of the current
         * city node, and selecting
         * the one with the smallest weight(distance between the two nodes)
         * choosing that city and looping
         * while the citiesLeft to visit is not empty. Since it finds a path
         * simply based off the neighbors
         * it is not gurnateed the be the shortest path through all the nodes.
         * graph: is a DGraph that contains the connections between the nodes
         * and their weights.
         * path: is a Trip object that represent the path through the nodes.
         */
        public static void heuristicMethod(DGraph graph, Trip path) {
            int numNodes = graph.getNumNodes();
            int curCity = 1;
            for (int k = 2; k <= numNodes; k++) {
                if (path.citiesLeft().isEmpty()) {
                    break;
            }
            ArrayList<Integer> neighbors = (ArrayList<Integer>) graph
                    .getNeighbors(curCity);
            double distance = -1.0;
            int nextCity = 0;
            for (int index = 0; index < neighbors.size(); index++) {
                int nextPossible = neighbors.get(index);
                if (path.isCityAvailable(nextPossible)) {
                    if (distance < 0
                            || distance > graph.getWeight(curCity,
                                    nextPossible)) {
                        distance = graph.getWeight(curCity, nextPossible);
                        nextCity = nextPossible;
                    }
                }
            }
            curCity = nextCity;
            path.chooseNextCity(curCity);
        }
    }

    /*
     * This function takes one parameter a String filename that is the .mtx file
     * that contains a matrix of that contains the information of the DGraph
     * that is to be created.
     * It creates a file object, and opens an input stream for the file and a
     * bufferedReader to go through the lines of the file. Reading through the
     * until all the comments of the file are passed(comment lines are preceded
     * by "%")
     * The first line after the comments will give the dimensions of the matric
     * and
     * number of edges that exists. Then loop through the remaining lines, this
     * lines contain
     * two nodes and a weight, and add the edge to the graph object with
     * addEdge(node1, node2, weight)
     * fileName: is a String that is the file that is to be read through.
     * return: graph.
     */
    public static DGraph getDGraph(String fileName) throws IOException {
        File file = new File(fileName);
        InputStream matrix = new FileInputStream(file);
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(matrix))) {
            String line = br.readLine();
            boolean comment = true;
            while (comment) {
                line = br.readLine();
                comment = line.startsWith("%");
            }
            String[] dimensions = line.split("( )+");
            DGraph graph = new DGraph(Integer.valueOf(dimensions[0]));
            while (true) {
                line = br.readLine();
                if (line == null)
                    break;
                dimensions = line.split("( )+");
                graph.addEdge(Integer.valueOf(dimensions[0]),
                        Integer.valueOf(dimensions[1]),
                        Double.valueOf(dimensions[2]));
            }
            matrix.close();
            return graph;
        }
    }
}
