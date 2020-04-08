# Graph Algorithm

###_Graph processing challenges_

1) Is a graph biparite? 
Answer : You can use DFS to do it by labelling vertices in such a way to understand

2) Is a dating graph biparite
   Answer : Not these days

3) Find a cycle? 
   Answer: use DFS

4) Konigsberg bridge problem
   Answer : if its connected and if all vertices have even degree we can.
   
5) Find a cycle that uses every edge exactly once.
   Answer : use of biparte

6) Find a cycle that visits every vertex exactly once.
    Answer : Hamiliton cycle NP problem

7) Are two graphs are identical except vertex names
   Answer :  no one knows efficent one
   
8) Lay out graph in the plane without crossing edges
   Answer :  Linear time DFS based planarity algo by Tarjan
   
 ### Every program is called Digraph. Digraph applications
 **Vertex** = basic block of instructions
 
 Edge = jump.
 
 1) Find and removed unreachable code.
 2) Infinite loop detection.
 
 **Garabge collection**
 
 V = Object
 Edge = reference.
 
 Mark-sweep algorithms
 Run dfs to mark. if unmarked it is gc
 
 
 BFS is a directed graph algorithm.
 
 ### Topological Sort
 0 -> 5
 0 -> 1
 3 -> 5
 5 -> 2
 6 -> 0
 1 -> 4
 0 -> 2
 3 -> 6
 3 -> 4
 5 -> 2
 6 -> 4
 3 -> 2
 1 -> 4
 
 run dfs.
 0 start here and take the last leaf node 
 postorder 4 1 2 5 0 6 3
 
 