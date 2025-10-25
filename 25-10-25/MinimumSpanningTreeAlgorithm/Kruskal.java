import java.util.*;

class KruskalsAlgorithm {
    static class Edge implements Comparable<Edge> {
        int src, dest, weight;
        Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }
        public int compareTo(Edge other) {
            return this.weight - other.weight;
        }
    }

    static int findParent(int node, int[] parent) {
        if (node == parent[node])
            return node;
        return parent[node] = findParent(parent[node], parent); // path compression
    }

    static void union(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);
        if (u == v) return;
        if (rank[u] < rank[v]) parent[u] = v;
        else if (rank[v] < rank[u]) parent[v] = u;
        else {
            parent[v] = u;
            rank[u]++;
        }
    }

    static void kruskalMST(List<Edge> edges, int V) {
        Collections.sort(edges);
        int[] parent = new int[V];
        int[] rank = new int[V];

        for (int i = 0; i < V; i++) parent[i] = i;

        int totalWeight = 0;
        List<Edge> mst = new ArrayList<>();

        for (Edge e : edges) {
            int uParent = findParent(e.src, parent);
            int vParent = findParent(e.dest, parent);

            if (uParent != vParent) {
                mst.add(e);
                totalWeight += e.weight;
                union(uParent, vParent, parent, rank);
            }
        }

        System.out.println("Edges in MST (Kruskal’s):");
        for (Edge e : mst) {
            System.out.println(e.src + " - " + e.dest + " : " + e.weight);
        }
        System.out.println("Total Weight of MST (Kruskal’s): " + totalWeight);
    }

    public static void main(String[] args) {
        int V = 5;
        List<Edge> edges = new ArrayList<>();

        // Undirected weighted edges
        edges.add(new Edge(0, 1, 2));
        edges.add(new Edge(0, 3, 6));
        edges.add(new Edge(1, 2, 3));
        edges.add(new Edge(1, 3, 8));
        edges.add(new Edge(1, 4, 5));
        edges.add(new Edge(2, 4, 7));

        kruskalMST(edges, V);
    }
}
