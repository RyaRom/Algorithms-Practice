package FloydWarshall;

import java.util.Arrays;

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] graph = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(graph[i], 10001);
            graph[i][i] = 0;
        }

        for (int[] edge : edges) {
            int from = edge[0];
            int to = edge[1];
            int weight = edge[2];
            graph[from][to] = weight;
            graph[to][from] = weight;
        }

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (graph[i][j] > graph[i][k] + graph[k][j]) {
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        int minReachable = Integer.MAX_VALUE;
        int cityWithMinReachable = -1;

        for (int i = 0; i < n; i++) {
            int reachableCities = 0;
            for (int j = 0; j < n; j++) {
                if (graph[i][j] <= distanceThreshold) {
                    reachableCities++;
                }
            }
            reachableCities--;

            if (reachableCities < minReachable ||
                    (reachableCities == minReachable && i > cityWithMinReachable)) {
                minReachable = reachableCities;
                cityWithMinReachable = i;
            }
        }

        return cityWithMinReachable;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int result = solution.findTheCity(4, new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}}, 4);
        System.out.println(result);
    }
}
