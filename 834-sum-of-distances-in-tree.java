class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        ArrayList<Integer>[] adjacencyList = new ArrayList[n];
        for (int index = 0; index < n; index++) {
            adjacencyList[index] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            adjacencyList[node1].add(node2);
            adjacencyList[node2].add(node1);
        }
        int[] nodeCountArray = new int[n];
        countNodes(adjacencyList, 0, nodeCountArray, new boolean[n]);

        int[] distances = new int[n];
        distances[0] = calculateRootDistance(adjacencyList, 0, nodeCountArray, new boolean[n]);

        calculateDistances(adjacencyList, 0, nodeCountArray, new boolean[n], distances);

        return distances;
    }

    private int countNodes(ArrayList<Integer>[] graph, int src, int[] countArray, boolean[] visited) {
        visited[src] = true;
        int count = 1;
        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                count += countNodes(graph, neighbor, countArray, visited);
            }
        }
        countArray[src] = count;
        return count;
    }

    private int calculateRootDistance(ArrayList<Integer>[] graph, int src, int[] countArray, boolean[] visited) {
        visited[src] = true;
        int distance = 0;
        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                distance += calculateRootDistance(graph, neighbor, countArray, visited) + countArray[neighbor];
            }
        }
        return distance;
    }

    private void calculateDistances(ArrayList<Integer>[] graph, int src, int[] countArray, boolean[] visited,
            int[] distances) {
        visited[src] = true;
        for (int neighbor : graph[src]) {
            if (!visited[neighbor]) {
                distances[neighbor] = distances[src] + graph.length - 2 * countArray[neighbor];
                calculateDistances(graph, neighbor, countArray, visited, distances);
            }
        }
    }
}
