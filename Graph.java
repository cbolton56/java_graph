/*
 * 
 */

/**
 *
 * @author cortb
 */

import java.util.*;

public class Graph {
    // Number of nodes in the graph
    private int n_nodes; 
    // Number of edges in the graph
    private int n_edges; 
    
    // Hashtable to hold the node edge pairs
    Hashtable<String, ArrayList<String>> G;
    boolean verbose = true; 

    // Default Constructor
    Graph() {
        if(this.verbose)
        {
            System.out.println("constructor");
        }
        n_nodes = 0; 
        n_edges = 0;
        G = new Hashtable<String, ArrayList<String>>();
        // G = new Hashtable<String, String>(); 
        this.G = G; 
        this.verbose = verbose; 
        // System.out.println(G.toString());
    } 
    
    // Get number of nodes in the graph
    int getNumNodes()
    {
        return n_nodes; 
    }
    
    // Get number of edges in the graph
    int getNumEdges()
    {
        return n_edges; 
    }
       
    // Adds a new node to the graph
    void add_node(String node){
        ArrayList L = new ArrayList<String>();
        this.G.put(node, L);
        this.n_nodes++; 
        if (this.verbose)
            System.out.println(G.toString());
    }
    
    // Adds multiple nodes to the graph
    void add_nodes(ArrayList<String> list)
    {
        // Function adds multiple nodes to the graph, 
        // in the form ["a", "b", "c"], etc. 
        for(int i = 0; i < list.size(); i++)
        {
            //String temp = list.get(i); 
            this.add_node(list.get(i)); 
        }
        /*
        for(int i = 0; i < list.size(); i++)
        {
            ArrayList L = new ArrayList<String>();
            this.G.put(list.get(i), L);
            this.n_nodes++; 
        } */ 
        if(this.verbose)
            System.out.println(G.toString());
    }
    
    void add_edge(String v1, String v2)
    {        
        ArrayList<String> temp; 
        temp = this.G.get(v1);
        temp.add(v2);
        temp = this.G.get(v2);
        temp.add(v1); 
    }
    
    // Takes in an arraylist of size 2 arrays to add as edges.  
    void add_edges(ArrayList<ArrayList<String>> edgeList)
    {
        for(int i = 0; i < edgeList.size(); i++){
            String node1 = (edgeList.get(i).get(0)); 
            String node2 = (edgeList.get(i).get(1));
            // System.out.println(node2.getClass().getName());
            this.add_edge(node1, node2); 
        }
    }
    
    void edges()
    { 
        this.G.values().iterator().forEachRemaining(System.out::print);
        System.out.println();
    }
    
    void nodes()
    {
        System.out.println(this.G.keySet());
        System.out.println(); 
        // System.out.println(G.toString());
    }
    
    ArrayList<ArrayList<String>> getEdges()
    {
        // declare main array list
        ArrayList<ArrayList<String>> edgeTuples = new ArrayList<>(); 
        // a list of the keys (nodes) in the graph 
        ArrayList<String> keys = new ArrayList<>(); 
        keys.addAll(this.G.keySet());
        // System.out.println("is keys filling up? " + keys.toString());
        // System.out.println("n nodes: " + this.n_nodes);
        for(int i = 0; i < n_nodes; i++)
        {
            // Get the i'th key in the keys
            String key = keys.get(i); 
            // System.out.println("Is the key being fetched correctly? " + key); 
            // Get neighbors of the key
            ArrayList<String> neighbors = new ArrayList<>(); 
            neighbors = this.getNeighbors(key); 
            for(int j = 0; j < neighbors.size(); j++)
            {
                ArrayList<String> pair = new ArrayList<>(); 
                pair = new ArrayList<>(Arrays.asList(key, neighbors.get(j))); 
                edgeTuples.add(pair); 
            }
        }
        return edgeTuples; 
    }
    
    ArrayList<String> getNodes()
    {
        if(this.verbose)
        {
            System.out.println("GetNodes "); 
        } 
        // New array list to store the list of nodes
        ArrayList<String> nodeList = new ArrayList<String>(); 
        // keySet returns a set of all the keys in the hashtable, which is then added to the list.
        nodeList.addAll(this.G.keySet()); 
        return nodeList; 
    }
    
    void neighbors(String node)
    {
        ArrayList<String> neighborList = this.G.get(node); 
        System.out.println("Neighbors of node " + node + ": " + neighborList.toString());      
    }
    
    ArrayList<String> getNeighbors(String node)
    { 
        ArrayList<String> neighborList = this.G.get(node); 
        return neighborList; 
    }
}

