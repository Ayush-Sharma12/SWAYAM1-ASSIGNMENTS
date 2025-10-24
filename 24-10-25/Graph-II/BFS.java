import java.util.*;

class Solution {
    // Function to return BFS traversal of the graph
    public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size(); // number of vertices
        ArrayList<Integer> bfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();

        // Usually, BFS starts from vertex 0
        visited[0] = true;
        queue.add(0);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfsTraversal.add(node);

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return bfsTraversal;
    }

    // Optional main method for testing
    public static void main(String[] args) {
        int V = 5;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());

        // Sample edges
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(0);
        adj.get(1).add(3);
        adj.get(2).add(0);
        adj.get(2).add(4);
        adj.get(3).add(1);
        adj.get(4).add(2);

        Solution sol = new Solution();
        ArrayList<Integer> bfsResult = sol.bfs(adj);
        System.out.println("BFS Traversal: " + bfsResult);
    }
}
