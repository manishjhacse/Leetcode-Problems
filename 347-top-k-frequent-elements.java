class Number implements Comparable<Number> {
    int element;
    int freq;

    Number(int element, int freq) {
        this.element = element;
        this.freq = freq;
    }

    @Override
    public int compareTo(Number that) {
        return this.freq - that.freq;
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Number> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Number number = new Number(entry.getKey(), entry.getValue());
            pq.offer(number);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().element;
        }
        return res;
    }
}