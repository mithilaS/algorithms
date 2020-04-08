package com.mithi.algorithms.graph;


import edu.princeton.cs.algs4.*;

/**
 que    v  edgeTo[]  disTo[]
 0  -         0
 4     1  0         1
 3     2  0         1
 5     3  2         2
 1
 2
 0
 put s in fifo queue and mark as visited
 repeat unti the queue is empty
 - remove each of rhe least recently used vertex. check all neighbours of vertex
 */
public class BreadthFirstSearchPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int[] distTo;

    public BreadthFirstSearchPaths(Graph g, int s) {
        edgeTo = new int[g.vertices()];
        distTo = new int[g.vertices()];
        marked = new boolean[g.vertices()];
    }

    private void bfs(Graph graph , int s){

        Queue<Integer> q= new Queue<>();

        q.enqueue(s);
        marked[s]=true;
        distTo[s] = 0;
        while(!q.isEmpty()){
            int v = q.dequeue();
            for(int w : graph.adj(v)){
                if(!marked[w]){
                    q.enqueue(w);
                    marked[w]=true;
                    edgeTo[w]=v;
                    distTo[w]=distTo[v]+1;
                }
            }
        }
    }

    /**
     * Is there a path between the source vertex <tt>s</tt> (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return <tt>true</tt> if there is a path, and <tt>false</tt> otherwise
     */
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    /**
     * Returns the number of edges in a shortest path between the source vertex <tt>s</tt>
     * (or sources) and vertex <tt>v</tt>?
     * @param v the vertex
     * @return the number of edges in a shortest path
     */
    public int distTo(int v) {
        return distTo[v];
    }

    /**
     * Returns a shortest path between the source vertex <tt>s</tt> (or sources)
     * and <tt>v</tt>, or <tt>null</tt> if no such path.
     * @param v the vertex
     * @return the sequence of vertices on a shortest path, as an Iterable
     */
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }

    /**
     * Unit tests the <tt>BreadthFirstPaths</tt> data type.
     */
    public static void main(String[] args) {
        In in = new In(args[0]);
       Graph G = new Graph(in);
        // StdOut.println(G);

        int s = Integer.parseInt(args[1]);
        BreadthFirstSearchPaths bfs = new BreadthFirstSearchPaths(G, s);

        for (int v = 0; v < G.vertices(); v++) {
            if (bfs.hasPathTo(v)) {
                StdOut.printf("%d to %d (%d):  ", s, v, bfs.distTo(v));
                for (int x : bfs.pathTo(v)) {
                    if (x == s) StdOut.print(x);
                    else        StdOut.print("-" + x);
                }
                StdOut.println();
            }

            else {
                StdOut.printf("%d to %d (-):  not connected\n", s, v);
            }

        }
    }
}
