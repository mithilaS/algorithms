package com.mithi.algorithms.graph;

import com.mithi.algorithms.bag.Bag;
import edu.princeton.cs.algs4.In;

public class Graph {
    private final int vertices;
    private int edges;
    private Bag<Integer>[] adj;


    public Graph(int v) {
        this.vertices = v;
        edges =0;
        adj = new Bag[v];
        for(int i=0;i<v;i++){
            adj[i]= new Bag<Integer>();
        }
    }

    public Graph(In in) {
        this(in.readInt());
        int edges = in.readInt();

        for(int i = 0; i < edges; i++) {
            int vertex1 = in.readInt();
            validateVertex(vertex1);

            int vertex2 = in.readInt();
            validateVertex(vertex2);
            addEdge(vertex1, vertex2);
        }
    }
    // add edge v-w . Parallel edges and self loop allowed
    public void addEdge(int v, int w ){
        adj[v].add(w);
        adj[w].add(v);
        edges++;
    }

    public Iterable<Integer> adj(int v){
        return adj[v];
    }

    public int vertices() {
        return vertices;
    }

    /**
     * Returns the number of edges in this graph.
     *
     * @return the number of edges in this graph
     */
    public int edges() {
        return edges;
    }

    // throw an IllegalArgumentException unless {@code 0 <= v < V}
    private void validateVertex(int v) {
        if (v < 0 || v >= vertices)
            throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (vertices-1));
    }

    /**
     * Returns the degree of vertex {@code v}.
     *
     * @param  v the vertex
     * @return the degree of vertex {@code v}
     * @throws IllegalArgumentException unless {@code 0 <= v < V}
     */
    public int degree(int v) {
        validateVertex(v);
        return adj[v].size();
    }

    /**
     * Returns a string representation of this graph.
     *
     * @return the number of vertices <em>V</em>, followed by the number of edges <em>E</em>,
     *         followed by the <em>V</em> adjacency lists
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(vertices + " vertices, " + edges + " edges " + "\n");
        for (int v = 0; v < vertices; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
