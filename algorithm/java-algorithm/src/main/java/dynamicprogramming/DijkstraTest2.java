package dynamicprogramming;

import java.util.*;

class Test3Solution {
    public int[] solution(int n, int k, int[][] roads) {
        int[][] graph = new int[n][n];
        boolean[][] visited = new boolean[k + 1][n];
        List<Integer>[] dp = new ArrayList[k + 1];
        for (int i = 0; i <= k; i++) {
            dp[i] = new ArrayList<>();
        }
        dp[0].add(0);

        buildGraph(roads, graph);

        findReachableNodes(graph, visited, dp, k, n);


        if (dp[k].isEmpty())
            return new int[]{-1};

        return dp[k].stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    private static void buildGraph(int[][] roads, int[][] graph) {
        for (int[] road : roads) {
            int node1 = road[0];
            int node2 = road[1];
            int len = road[2];

            graph[node1][node2] = len;
            graph[node2][node1] = len;
        }
    }
    private void findReachableNodes(int[][] graph, boolean[][] visited, List<Integer>[] dp, int k, int n) {
        for (int time = 0; time < k; time++) {
            for (int node : dp[time]) {
                for (int i = 0; i < n; i++) {
                    if (graph[node][i] != 0) {
                        int nextTime = time + graph[node][i];
                        if (nextTime <= k && !visited[nextTime][i]) {
                            visited[nextTime][i] = true;
                            dp[nextTime].add(i);
                        }
                    }
                }
            }
        }
    }

}

public class DijkstraTest2 {
    public static void main(String[] args) {
//        int n = 6;
        int n = 4;
//        int k = 17;
        int k = 10;
//        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        int[][] roads = {{0,1,2}, {0,2,3}};
//
        int[] answer = new Test3Solution().solution(n,k,roads);

        System.out.println(Arrays.toString(answer));
    }
}