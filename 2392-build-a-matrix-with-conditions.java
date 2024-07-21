class Solution {
    int[] topoSort(int k, int pairs[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= k; i++) {
            adj.add(new ArrayList<>());
        }
        for (int pair[] : pairs) {
            int u = pair[0];
            int v = pair[1];
            adj.get(u).add(v);
        }
        int indegree[] = new int[k + 1]; // 0
        for (int u = 0; u < adj.size(); u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= k; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            res.add(node);
            for (int neighbour : adj.get(node)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        if (res.size() != k) {
            return new int[0];
        }

        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int[][] buildMatrix(int k, int[][] rowConditions, int[][] colConditions) {
        int rowTopoSort[] = topoSort(k, rowConditions);
        int colTopoSort[] = topoSort(k, colConditions);
        if (rowTopoSort.length == 0 || colTopoSort.length == 0) {
            return new int[0][0];
        }
        int ans[][] = new int[k][k];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rowTopoSort[i] == colTopoSort[j]) {
                    ans[i][j] = rowTopoSort[i];
                }
            }
        }
        return ans;
    }
}