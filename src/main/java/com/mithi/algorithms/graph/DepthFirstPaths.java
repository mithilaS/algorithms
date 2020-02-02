package com.mithi.algorithms.graph;

import java.util.Stack;

/*
Mark v as visited.
Recursively visit all unmarked vertices w adjacent to v.

Create a graph object. pass it
query graph processing routines
first mark it ... then all vertices adjancey to vertex
v   marked[]   edgeTo[v]
0   t           -
6   t           0
4   t           6
5   t           4
3   t           5
1   t           0
2   t           0
 */
public class DepthFirstPaths {

    private boolean[] marked;
    private int[] edgeTo;
    private int s;

    public DepthFirstPaths(Graph graph ,int s) {
        marked = new boolean[graph.vertices()];
        this.s = s;
        dfs(graph,s);
    }

    private void dfs(Graph graph, int v) {
        marked[v]=true;
        for(int w: graph.adj(v)){
            if(!marked[w]){
                dfs(graph ,w);
                edgeTo[w]=v;
            }
        }
    }

    public boolean hasPathTo(int v){
        return marked[v];
    }
    // add in reverse. then add s also
    public Iterable<Integer> pathTo(int v){
        if(!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        for(int x=v ; x!=s; x=edgeTo[x]){
            path.push(x);
        }
        path.push(s);
        return path;
    }
}
