package com.mithi.algorithms.graph;

public class DirectedDFS {
    private boolean[] marked;
    public DirectedDFS(Digraph d, int s) {
        marked = new boolean[d.vertices()];
        dfs(d,s);
    }

    private void dfs(Digraph d, int v) {
        marked[v] = true;
        for(int w: d.adj(v)){
            if(!marked[w]){
                dfs(d,w);
            }
        }
    }

    public boolean visited(int v){
        return marked[v];
    }
}
