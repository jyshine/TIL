package dynamicprogramming;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int id;
    int dist;

    public Node(int id, int dist) {
        this.id = id;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.dist, other.dist);
    }
}

public class DijkstraTest1 {
    public static void main(String[] args) {
        int n = 4;
        int k = 10;

        List<List<int[]>> graph = buildGraph(n);
        int[] distances = dijkstra(graph, k);

        List<Integer> reachableNodes = getReachableNodes(distances, k);
        System.out.println("Reachable nodes within " + k + " hours: " + reachableNodes);
    }

    private static List<List<int[]>> buildGraph(int n) {
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

//        int[][] roads = {{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}};
        int[][] roads = {{0, 1, 2}, {0, 2, 3}};

        for (int[] road : roads) {
            int from = road[0];
            int to = road[1];
            int distance = road[2];

            graph.get(from).add(new int[]{to, distance});
            graph.get(to).add(new int[]{from, distance});
        }
        graph.forEach(
                g -> g.forEach(
                        gg-> System.out.println(Arrays.toString(gg))
                )
        );
        return graph;
    }

    private static int[] dijkstra(List<List<int[]>> graph, int k) {
        int n = graph.size();
        int[] distances = new int[n];
        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[0] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.offer(new Node(0, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int id = node.id;
            int dist = node.dist;

            if (dist > distances[id]) {
                continue;
            }

            for (int[] neighbor : graph.get(id)) {
                int nextId = neighbor[0];
                int nextDist = dist + neighbor[1];

                if (nextDist < distances[nextId]) {
                    distances[nextId] = nextDist;
                    queue.offer(new Node(nextId, nextDist));
                }
            }
        }

        return distances;
    }

    private static List<Integer> getReachableNodes(int[] distances, int k) {
        List<Integer> reachableNodes = new ArrayList<>();

        for (int i = 0; i < distances.length; i++) {
            if (distances[i] <= k) {
                reachableNodes.add(i);
            }
        }

        return reachableNodes;
    }
}

