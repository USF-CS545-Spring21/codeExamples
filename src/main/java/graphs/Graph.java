package graphs;

public class Graph {
    private Edge[] graph; // adjacency list for this graph

    public Graph(int numVertices) {
        graph = new Edge[numVertices];
    }

    public void addEdge(int nodeId, Edge edge) {
        Edge current = graph[nodeId]; // head of the linked list for this  node
        graph[nodeId] = edge; // insert in front
        if (current != null) {
            edge.next = current;
        }
    }

    // Inner class Edge
    public static class Edge { // Inner class Edge
        private int neighbor; // id of the neighbor
        private Edge next; // reference to the next "edge"

        public Edge(int neighbor) {
            this.neighbor = neighbor;
            next = null;
        }
    } // class Edge

    public static void main(String[] args) {
        Graph g = new Graph(3);

        // edges going out of vertex 0
        Edge edge01 = new Edge(1);
        Edge edge02 = new Edge(2);
        g.addEdge(0, edge01);
        g.addEdge(0, edge02);

        // edges going out of vertex 1
        Edge edge12 = new Edge(2);
        g.addEdge(1, edge12);

        // edges going out of vertex 2
        Edge edge20 = new Edge(0);
        g.addEdge(2, edge20);

    }

}
