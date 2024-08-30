class Solution {
    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        List<Pair<Integer, Integer>>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++){
            int from = edges[i][0];
            int to = edges[i][1];

            graph[from].add(new Pair<>(to, i));
            graph[to].add(new Pair<>(from, i));
        }

        int[] minDist = new int[n];
        Arrays.fill(minDist, Integer.MAX_VALUE);
        minDist[source] = 0;

        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        pq.add(new Pair<>(source, 0));

        while(pq.size() > 0){
            Pair<Integer, Integer> curr = pq.remove();
            int u = curr.getKey();
            int wt = curr.getValue();

            if(wt > minDist[u]) continue;

            List<Pair<Integer, Integer>> neigh = graph[u];
            for(int i = 0; i < neigh.size(); i++){
                int v = neigh.get(i).getKey();
                int currWt = edges[neigh.get(i).getValue()][2];

                if(currWt == -1) currWt = 1;

                if(currWt + minDist[u] < minDist[v]){
                    minDist[v] = currWt + minDist[u];
                    pq.add(new Pair<>(v, minDist[v]));
                }
            }
        }

        int diff = target - minDist[destination];

        if(diff < 0) return new int[0][0];

        int[] modDist = new int[n];
        Arrays.fill(modDist, Integer.MAX_VALUE);
        modDist[source] = 0;

        pq = new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());
        pq.add(new Pair<>(source, 0));

        while(pq.size() > 0){
            Pair<Integer, Integer> curr = pq.remove();
            int u = curr.getKey();
            int wt = curr.getValue();

            if(wt > modDist[u]) continue;

            List<Pair<Integer, Integer>> neigh = graph[u];
            for(int i = 0; i < neigh.size(); i++){
                int v = neigh.get(i).getKey();
                int currWt = edges[neigh.get(i).getValue()][2];

                if(currWt == -1) {
                    currWt = 1;
                    int newWt = diff + minDist[v] - modDist[u];
                    if(newWt > currWt){
                        edges[neigh.get(i).getValue()][2] = newWt;
                        currWt = newWt;
                    }
                }

                if(currWt + modDist[u] < modDist[v]){
                    modDist[v] = currWt + modDist[u];
                    pq.add(new Pair<>(v, modDist[v]));
                }
            }
        }

        if(modDist[destination] < target) return new int[0][0];

        for(int[] edge: edges){
            if(edge[2] == -1) edge[2] = 1;
        }

        return edges;
    }
}