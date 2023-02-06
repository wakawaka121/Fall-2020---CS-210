import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*Edited by: Derek Tominaga*/
/**
 * DGraph.java
 * 
 * Represents a directed graph. The nodes are represented as
 * integers ranging from 1 to num_nodes inclusive.
 * The weights are assumed to be >= zero.
 * 
 * Usage instructions:
 * 
 * Construct a DGraph
 * DGraph graph = new DGraph(numNodes);
 * 
 * Add an edge
 * graph.addEdge(v, w, weight);
 * 
 * Other useful methods:
 * graph.getWeight(v,w)
 * graph.getNumNodes()
 * List<Integer> list = graph.getNeighbors(v);
 * 
 */
public class DGraph {
    /*
     * Fields
     * ----------------------------
     * numNodes:an int value representing the number of nodes, which represent
     * the number of cities that are to be visited.
     * edges: is a sorted list of the edges of the DGraph.
     * nodeLinks: is a Map where the Keys: nodes(cities), Values: is a
     * sorted list of nodes(cities) that are the neighbors
     * that key.
     * nodeSet: a set of all the nodes that exists for the DGraph
     */
    private int numNodes;
    private List<Edge> edges;
    private Map<Integer, List<Integer>> nodeLinks;
    private Set<Integer> nodeSet;

    /*
     * Constructs an instance of the DGraph class with # nodes numNodes.
     * Creates a new DGraph object and initializes the fields to:
     * numNodes set the number of nodes that exists in the DGraph
     * edges set to an empty ArrayList<Edge>
     * nodeLinks set to an empty HashMap<Integer, List<Integer>>
     * nodeSet creates a new HashSet<Integer> and adds the nodes to the set.
     */
    public DGraph(int numNodes) {
        this.numNodes = numNodes;
        this.edges = new ArrayList<Edge>();
        this.nodeLinks = new HashMap<Integer, List<Integer>>();
        this.nodeSet = new HashSet<Integer>();
        for (int node = 1; node <= numNodes; node++) {
            nodeSet.add(node);

        }
    }

    /**
     * Adds the directed edge (v,w) to the graph including updating the node
     * count appropriately.
     * Creates a new Edge with node1 = v and node2 = w and weight = distance.
     * Then adds this edge to edges field of the DGraph, then sorts edges.
     * Then checks to see if this was a node that exists in the read in matrix.
     * if v or w does not exists in the set of nodes, add them to the set of
     * nodes,
     * and increase the count of the number of nodes.
     * Then check if the node exist in the HashMap, if it does not create
     * a new ArrayList<Integer> add w to the ArrayList and then put v and the
     * ArrayList
     * into the HashMap. Else, update the ArrayList by adding w to it.
     * v: int value of a node directd to w
     * w: int value of node that is a edge that exists between v and w.
     * distance: is a double value that represent the weight of the edges
     * between v and w.
     * 
     * @param v
     * @param w
     */
    public void addEdge(int v, int w, double distance) {
        Edge newEdge = new Edge(v, w, distance);
        this.edges.add(newEdge);
        Collections.sort(edges);
        if (!nodeSet.contains(v)) {
            nodeSet.add(v);
            numNodes++;
        }
        if (!nodeSet.contains(w)) {
            nodeSet.add(w);
            numNodes++;
        }

        if (!nodeLinks.containsKey(v)) {
            List<Integer> linkList = new ArrayList<Integer>();
            linkList.add(w);
            nodeLinks.put(v, linkList);
        } else {
            nodeLinks.get(v).add(w);
        }
    }

    /*
     * Returns the number of nodes in this graph.
     */
    public int getNumNodes() {
        return this.numNodes;
    }

    // Returns the weight for the given edge.
    // Returns -1 if there is no edge between the nodes v and w.
    public double getWeight(int v, int w) {
        for (Edge edge : edges) {
            if (edge.node1 == v && edge.node2 == w) {
                return edge.weight;
            }
        }
        return -1;
    }

    /**
     * For a given node returns a sorted list of all its neighbors.
     * 
     * @param v
     *            Node identifier
     * @return A sorted list of v's neighbors.
     */
    public List<Integer> getNeighbors(int v) {
        List<Integer> temp = nodeLinks.get(v);
        Collections.sort(temp);
        return temp;
    }

    /* --------------------------------------- */
    /*
     * You should not need to touch anything below this line,
     * except for maybe the name edges in the for each loop just below
     * in the toDotString method if you named your collection of edges
     * differently.
     */
    // Create a dot representation of the graph.
    public String toDotString() {
        String dot_str = "digraph {\n";
        // Iterate over the edges in order.
        for (Edge e : edges) {
            dot_str += e.toDotString() + "\n";
        }
        return dot_str + "}\n";
    }

    /**
     * Immutable undirected edges.
     */
    public class Edge implements Comparable<Edge> {

        // Nodes in edge and weight on edge
        private final int node1;
        private final int node2;
        private final double weight;
        
        /**
         * Stores the given nodes with smaller id first.
         * 
         * @param node1
         * @param node2
         */
        public Edge(int node1, int node2, double weight) {
            assert weight >= 0.0;
            this.node1 = node1;
            this.node2 = node2;
            this.weight = weight;
        }

        /**
         * @return an directed edge string in dot format
         */
        public String toDotString() {
            return "" + node1 + " -> " + node2 + " [label=\"" + weight
                    + "\"];";
        }

        /**
         * Lexicographical ordering on edges (node1,node2).
         */
        public int compareTo(Edge other) {
            if (this.equals(other)) {
                return 0; // this and other are equal
            } else if ((node1 < other.node1)
                    || (node1 == other.node1 && node2 < other.node2)) {
                return -1; // this is less than other
            } else {
                return 1; // this is greater than other
            }
        }

        /**
         * Lexicographical ordering on edges (node1,node2).
         */
        public boolean equals(Object o) {
            if (!(o instanceof Edge)) {
                return false;
            }
            Edge other = (Edge) o;
            return (node1 == other.node1) && (node2 == other.node2);
        }

        /**
         * Know number of nodes when read in input file, so can give each edge a
         * unique hash code.
         */
        public int hashCode() {
            return getNumNodes() * node1 + node2;
        }
    }

}
