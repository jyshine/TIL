package dynamicprogramming;

import java.util.Arrays;

/**
 * 예제는 9개의 정점과 해당 정점들 간의 가중치를 가진 그래프를 인접 행렬로 표현합니다.
 * `dijkstra` 메서드는 출발점으로부터 모든 정점까지의 최단 거리를 계산하고 출력합니다.
 * `findMinDistance` 메서드는 아직 방문하지 않은 정점 중에서 최단 거리를 가지는 정점을 찾습니다.
 *
 * 주어진 그래프에서 출발점은 0번 정점입니다.
 * 따라서 위의 예제를 실행하면 출발점으로부터 각 정점까지의 최단 거리가 출력됩니다.
 *
 */
public class DijkstraAlgorithm {
    private static final int INF = Integer.MAX_VALUE; // 무한대 값으로 초기화

    public void dijkstra(int[][] graph, int start) {
        int vertices = graph.length;
        int[] distances = new int[vertices]; // 출발점으로부터의 거리 저장
        boolean[] visited = new boolean[vertices]; // 방문 여부 저장

        Arrays.fill(distances, INF); // 거리를 무한대로 초기화
        distances[start] = 0; // 출발점의 거리는 0

        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinDistance(distances, visited); // 최단 거리를 갖는 정점 선택
            visited[minVertex] = true; // 해당 정점을 방문으로 처리

            for (int j = 0; j < vertices; j++) {
                // 아직 방문하지 않았고, 경로가 존재하며, 기존 거리보다 더 짧은 경로인 경우 거리 업데이트
                if (!visited[j] && graph[minVertex][j] != 0 && distances[minVertex] != INF &&
                        distances[minVertex] + graph[minVertex][j] < distances[j]) {
                    distances[j] = distances[minVertex] + graph[minVertex][j];
                }
            }
        }

        // 결과 출력
        for (int i = 0; i < vertices; i++) {
            System.out.println("Vertex " + i + ": Distance = " + distances[i]);
        }
    }

    private int findMinDistance(int[] distances, boolean[] visited) {
        int minDistance = INF;
        int minVertex = -1;

        for (int i = 0; i < distances.length; i++) {
            if (!visited[i] && distances[i] < minDistance) {
                minDistance = distances[i];
                minVertex = i;
            }
        }

        return minVertex;
    }

    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6        },
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };

        DijkstraAlgorithm dijkstra = new DijkstraAlgorithm();
        dijkstra.dijkstra(graph, 0);
    }
}
