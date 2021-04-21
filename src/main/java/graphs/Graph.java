package graphs;

import queues.ArrayQueue;
import queues.Queue;
import stacks.ArrayStack;
import stacks.Stack;

/** Class Graph. A graph is represented using an adjacency list */
public class Graph {
    private Edge[] graph; // adjacency list for this graph

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    /**
     * Adds the given edge as an outgoing edge for the given vertex.
     * Modifies the adjacency list.
     * @param vertexId  id of the vertex
     * @param edge outgoing edge
     */
    public void addEdge(int vertexId, Edge edge) {
        Edge head = graph[vertexId]; // head of the linked list for this  node
        graph[vertexId] = edge; // insert in front
        if (head != null) {
            edge.next = head;
        }
    }

    /**
     * Returns the first neighbor of the vertex.
     * Takes the first edge going out of this vertex and returns the index of the neighbor
     * where this edge is going.
     * @param vertexId id of the vertex
     * @return id of first neighbor
     */
    public int getFirstNeighbor(int vertexId) {
        Edge first = graph[vertexId];
        if (first != null)
            return first.neighbor;
        else {
            System.out.println("No edges");
            return Integer.MIN_VALUE;
        }

    }

    /**
     * Returns the number of outgoing edges for a given vertex
     * @param vertexId id of the vertex
     * @return number of outgoing edges
     */
    public int numOutgoingEdges(int vertexId) {
        int num = 0;
        Edge curr;
        if (vertexId < 0 || vertexId >= graph.length) {
            throw new IllegalArgumentException();
        }
        for (curr = graph[vertexId]; curr != null; curr = curr.next) {
            num++;
        }

        return num;
    }

    /**
     * Runs DFS starting from a given source vertex.
     * Recursive implementation.
     *
     * @param vertex id os the source vertex
     * @param visited boolean array that tells us whether each vertex has been visited or not
     */
    public void dfsHelperRecursive(int vertex, boolean[] visited) {
        Edge tmp;
        visited[vertex] = true;
        System.out.println("Visited " +  vertex);

        // iterate over outgoing edges of the vertex
        for (tmp = graph[vertex]; tmp!=null; tmp = tmp.next)  {
            if (!visited[tmp.neighbor])
                dfsHelperRecursive(tmp.neighbor, visited);
        }
    }

    /**
     * Runs DFS starting from a given source vertex.
     * Non-recursive implementation using a stack.
     *
     * @param vertex id os the source vertex
     * @param visited boolean array that tells us whether each vertex has been visited or not
     */
    public void dfsHelperUsingStack(int vertex, boolean[] visited) {
        Edge tmp;
        Stack stack = new ArrayStack();
        stack.push(vertex);

        while (!stack.empty()) {
            int nextV = (int)stack.pop();
            if (!visited[nextV]) {
                visited[nextV] = true;
                System.out.println("Visited " + nextV);
                for (tmp = graph[nextV]; tmp != null; tmp = tmp.next) {
                    if (!visited[tmp.neighbor])
                        stack.push(tmp.neighbor);
                }
            }
        }
    }

    /** Traverses the graph using DFS or BFS
     *
     * @param method Name of the method to use "DFS" or "BFS".
     */
    public void traverseGraph(String method) {
        boolean[] visited = new boolean[graph.length];
        // Will make sure we visit all the vertices by starting dfsHelper from each unvisited vertex
        for (int i = 0; i < graph.length; i++) {
            if (!visited[i]) {
                if (method.equals("DFS"))
                    dfsHelperRecursive(i, visited);
                    // dfsHelperUsingStack(i , visited); // we could use this one instead of dfsHelper
                else if (method.equals("BFS"))
                    bfsHelper(i, visited);
                else {
                    System.out.println("No such method. We can perform only DFS or BFS traversal");
                    throw new IllegalArgumentException();
                }

            }
        }

    }

    /**
     * Runs BFS starting from a given source vertex.
     * Uses a queue.
     * @param vertex id os the source vertex
     * @param visited boolean array that tells us whether each vertex has been visited or not
     */
    public void bfsHelper(int vertex, boolean[] visited) {
        Edge tmp;
        int nextV;
        Queue queue = new ArrayQueue();
        visited[vertex] = true;
        System.out.println("Visited " + vertex);
        queue.enqueue(vertex);
        while (!queue.empty()) {
            nextV = (Integer)queue.dequeue();
            for (tmp = graph[nextV]; tmp != null; tmp = tmp.next) {
                if (!visited[tmp.neighbor]) {
                    visited[tmp.neighbor] = true;
                    System.out.println("Visited " + tmp.neighbor);
                    queue.enqueue(tmp.neighbor);
                }

            }
        }
    }

    // Static nested class Edge
    public static class Edge { // Class Edge
        private int neighbor; // id of the neighbor
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public static void main(String[] args) {
        Graph g = new Graph(4);

        // edges going out of vertex 0
        Edge edge01 = new Edge(1);
        Edge edge02 = new Edge(2);
        g.addEdge(0, edge01);
        g.addEdge(0, edge02);

        // edges going out of vertex 1
        Edge edge12 = new Edge(2);
        Edge edge13 = new Edge(3);
        g.addEdge(1, edge12);
        g.addEdge(1, edge13);


        // edges going out of vertex 2
        Edge edge20 = new Edge(0);
        g.addEdge(2, edge20);

        // edges going out of vertex 3
        Edge edge30 = new Edge(0);
        Edge edge31 = new Edge(1);
        g.addEdge(3, edge30);
        g.addEdge(3, edge31);

        System.out.println(g.getFirstNeighbor(0)); // vertex 2 since it was added before 1
        System.out.println(g.numOutgoingEdges(1));

        System.out.println("Traversing the graph: ");
        g.traverseGraph("DFS");


    }

}
