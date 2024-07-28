import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            adj.add(new ArrayList<>());
        }
        for (int edge[] : edges) {
            int a = edge[0];
            int b = edge[1];
            adj.get(a).add(b);
            adj.get(b).add(a);
        }
        int timeTaken[][] = new int[n + 1][2];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(timeTaken[i], Integer.MAX_VALUE);
        }
        Queue<int[]> queue = new LinkedList<>();
        timeTaken[1][0] = 0;
        queue.offer(new int[] { 1, 0 });
        while (!queue.isEmpty()) {
            int element[] = queue.poll();
            int node = element[0];
            int curTime = element[1];
            if (node == n) {
                if (timeTaken[node][1] != Integer.MAX_VALUE) {
                    break;
                }
            }
            if ((curTime / change) % 2 != 0) {
                int waitTime = change - (curTime % change);
                curTime += waitTime + time;
            } else {
                curTime += time;
            }
            for (int neighbour : adj.get(node)) {
                if (timeTaken[neighbour][0] == Integer.MAX_VALUE) {
                    timeTaken[neighbour][0] = curTime;
                    queue.offer(new int[] { neighbour, curTime });
                } else if (timeTaken[neighbour][1] == Integer.MAX_VALUE && curTime > timeTaken[neighbour][0]) {
                    timeTaken[neighbour][1] = curTime;
                    queue.offer(new int[] { neighbour, curTime });
                }
            }
        }
        return timeTaken[n][1];
    }
}