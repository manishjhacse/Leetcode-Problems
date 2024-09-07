class Project implements Comparable<Project> {
    int capital;
    int profit;

    Project(int capital, int profit) {
        this.capital = capital;
        this.profit = profit;
    }

    public int compareTo(Project that) {
        return this.capital - that.capital;
    }

}

class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Project> minPQ = new PriorityQueue<>();
        for (int i = 0; i < profits.length; i++) {
            minPQ.offer(new Project(capital[i], profits[i]));
        }
        PriorityQueue<Integer> maxPQ = new PriorityQueue<>(Collections.reverseOrder());
        while (k > 0) {
            while (!minPQ.isEmpty() && minPQ.peek().capital <= w) {
                maxPQ.offer(minPQ.poll().profit);
            }
            if (maxPQ.isEmpty()) {
                return w;
            }
            w += maxPQ.poll();
            k--;
        }

        return w;
    }
}