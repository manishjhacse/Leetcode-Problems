class Pair implements Comparable<Pair> {
    char ch;
    int freq;

    Pair(char ch, int freq) {
        this.ch = ch;
        this.freq = freq;
    }

    @Override
    public int compareTo(Pair that) {
        if (that.freq == this.freq) {
            return this.ch - that.ch;
        }
        return that.freq - this.freq; // maxheap
    }
}

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        StringBuilder ans = new StringBuilder();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(new Pair(entry.getKey(), entry.getValue()));
        }
        while (!pq.isEmpty()) {
            Pair pair = pq.poll();
            char ch = pair.ch;
            int freq = pair.freq;
            while (freq > 0) {
                ans.append(ch);
                freq--;
            }

        }
        return ans.toString();
    }
}