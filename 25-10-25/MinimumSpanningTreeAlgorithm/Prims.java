import java.util.*;

class PrimsAlgorithm {
    static class Edge {
        int dest, weight;
        Edge(int dest, int weight) {
            this.dest = dest;
            this.weight = weight;
        }
    }

    static void primMST(List<List<Edge>> graph, int V) {
        // Array to track visited nodes
        boolean[] visited = new boolean[V];
        // Min-heap based on edge weight
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        // Add first vertex (0) with weight 0
        pq.add(new int[]{0, 0});
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int node = curr[0];
            int weight = curr[1];

            if (visited[node]) continue;
            visited[node] = true;
            totalWeight += weight;

            for (Edge e : graph.get(node)) {
                if (!visited[e.dest]) {
                    pq.add(new int[]{e.dest, e.weight});
                }
            }
        }

        System.out.println("Total Weight of MST (Prim’s): " + totalWeight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // Undirected weighted graph
        graph.get(0).add(new Edge(1, 2));
        graph.get(0).add(new Edge(3, 6));
        graph.get(1).add(new Edge(0, 2));
        graph.get(1).add(new Edge(2, 3));
        graph.get(1).add(new Edge(3, 8));
        graph.get(1).add(new Edge(4, 5));
        graph.get(2).add(new Edge(1, 3));
        graph.get(2).add(new Edge(4, 7));
        graph.get(3).add(new Edge(0, 6));
        graph.get(3).add(new Edge(1, 8));
        graph.get(4).add(new Edge(1, 5));
        graph.get(4).add(new Edge(2, 7));

        primMST(graph, V);
    }
}
