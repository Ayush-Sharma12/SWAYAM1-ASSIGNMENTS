
import java.util.*;

public class Dijkstra {

      static class Pair {

            int vertex;
            int weight;

            Pair(int vertex, int weight) {
                  this.vertex = vertex;
                  this.weight = weight;
            }

      }

      int[] getShortestPath(List<List<Pair>> adj, int src) {

            int V = adj.size();
            Queue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
            pq.add(new int[] { src, 0 });

            int[] ans = new int[V];
            Arrays.fill(ans, Integer.MAX_VALUE);

            boolean[] vis = new boolean[V];

            while (!pq.isEmpty()) {

                  int[] temp = pq.poll();

                  int vertex = temp[0];
                  int cost = temp[1]; // d(u)

                  if (vis[vertex])
                        continue;

                  vis[vertex] = true;

                  for (Pair pair : adj.get(vertex)) {

                        int dest = pair.vertex;
                        int currCost = pair.weight; // c(u, v)
                        // Relaxation

                        /*
                         * if d(u) + c(u, v) < d(v)
                         * d(v) = d(u) + c(u, v)
                         */
                        int totalCost = cost + currCost;

                        if (totalCost < ans[dest]) {
                              ans[dest] = totalCost;
                        }

                        pq.add(new int[] { dest, ans[dest] });
                  }

            }

            return ans;
      }

      public static void main(String[] args) {

            List<List<Pair>> adj = new ArrayList<>();
            int V = 5;
            for (int i = 0; i < V; i++) {
                  adj.add(new ArrayList<>());
            }

            adj.get(0).add(new Pair(1, 2));
            adj.get(0).add(new Pair(3, 3));
            adj.get(1).add(new Pair(2, 4));
            adj.get(2).add(new Pair(5, 5));
            adj.get(3).add(new Pair(1, 2));

      }

}
