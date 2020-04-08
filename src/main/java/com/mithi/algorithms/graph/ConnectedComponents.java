package com.mithi.algorithms.graph;

/*
will usw dfs : all v as unmarked. for each unmarked v run dfs
v   id[v]
0   0
1   0
2   0
3   0
4   0
5   0
6   0
7   1
8   1
all connected component has same id
 */
public class ConnectedComponents {

    private boolean[] marked;
    private int[] id;
    private int[] size;
    private int count;

    public ConnectedComponents(Graph g) {
        marked = new boolean[g.vertices()];
        id = new int[g.vertices()];
        size = new int[g.vertices()];
        for (int v = 0; v < g.vertices(); v++) {
            if (!marked[v]) {
                dfs(g, v);
                count++;
            }
        }
    }

    // depth-first search
    private void dfs(Graph g, int v) {
        marked[v] = true;
        id[v] = count;
        size[count]++;
        for (int w : g.adj(v)) {
            if (!marked[w]) {
                dfs(g, w);
            }
        }
    }

    boolean connected(int v, int w){
        return id(v) == id(w);
    }

    int count(){
        return count;
    }

    int id(int v){
    return id[v];
    }
}
