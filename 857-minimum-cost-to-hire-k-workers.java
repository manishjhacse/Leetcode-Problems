class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        double minCost = Double.MAX_VALUE;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b) -> Double.compare(a.wageRatio(), b.wageRatio()));
        PriorityQueue<Integer> maxQualityHeap = new PriorityQueue<>(Collections.reverseOrder());
        int totalQuality = 0;
        for (Worker worker : workers) {
            maxQualityHeap.offer(worker.quality);
            totalQuality += worker.quality;
            if (maxQualityHeap.size() > k) {
                totalQuality -= maxQualityHeap.poll();
            }
            if (maxQualityHeap.size() == k) {
                minCost = Math.min(minCost, totalQuality * worker.wageRatio());
            }
        }
    
        return minCost;
    }
    
    class Worker {
        int quality;
        int wage;
        public Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
        }
        public double wageRatio() {
            return (double) wage / quality;
        }
    }
}