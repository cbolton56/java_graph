/*
 * A graph in Java
 * 
 * 
 */

/**
 *
 * @author cortb
 */

import java.util.*;

public class Main { 
    public static void main(String[] args){
        // Add to graph
        System.out.println("Hello world! "); 
        Graph g1 = new Graph(); 
        g1.add_node("bach"); 
        ArrayList<String> L = new ArrayList<String>(Arrays.asList("hilary", "tchaik", "shosty"));
        g1.add_nodes(L);
        g1.add_edge("bach", "tchaik"); 
        // Add an edge between shosty and tchaik
        ArrayList<String> temp = new ArrayList<>(Arrays.asList("shosty", "tchaik")); 
        ArrayList<ArrayList<String>> composers = new ArrayList<>(Arrays.asList(temp)); 
        g1.add_edges(composers);
        System.out.println("testing .edges method "); 
        g1.edges();
        System.out.println("test the .nodes method "); 
        g1.nodes();
        System.out.println(g1.getNodes()); 
        g1.neighbors("shosty");
        ArrayList<String> neighbors = new ArrayList<>(); 
        neighbors = g1.getNeighbors("shosty"); 
        System.out.println(neighbors.toString());  
        ArrayList<ArrayList<String>> edges = g1.getEdges(); 
        System.out.println("printing the return from get edges: " + edges.toString());

    } 
    
}
