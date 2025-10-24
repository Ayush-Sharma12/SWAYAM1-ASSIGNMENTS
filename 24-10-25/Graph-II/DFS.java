import java.util.*;


public class DFS {
    
}

class Solution {
    // Function to return DFS traversal of the graph
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size(); // number of vertices
        ArrayList<Integer> dfsTraversal = new ArrayList<>();
        boolean[] visited = new boolean[n];

        // Usually, DFS starts from vertex 0
        dfsHelper(0, adj, visited, dfsTraversal);

        return dfsTraversal;
    }

    // Recursive DFS helper function
    private void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> traversal) {
        visited[node] = true;
        traversal.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, traversal);
            }
        }
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
        ArrayList<Integer> dfsResult = sol.dfs(adj);
        System.out.println("DFS Traversal: " + dfsResult);
    }
}
