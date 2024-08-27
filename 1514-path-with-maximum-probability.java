class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        double pro[] = new double[n];
        pro[start_node] = 1;
        for (int i = 0; i < n - 1; i++) {
            int j = 0;
            boolean isChanged = false;
            for (int edge[] : edges) {
                int u = edge[0];
                int v = edge[1];
                double sp = succProb[j];
                if (pro[u] * sp > pro[v]) {
                    pro[v] = pro[u] * sp;
                    isChanged = true;
                }
                if (pro[v] * sp > pro[u]) {
                    pro[u] = pro[v] * sp;
                    isChanged = true;
                }
                j++;
            }
            if (!isChanged) {
                break;
            }
        }
        return pro[end_node];
    }
}