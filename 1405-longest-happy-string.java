import java.util.PriorityQueue;

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((p1, p2) -> p2.count - p1.count);
        if (a > 0)
            pq.offer(new Pair(a, 'a'));
        if (b > 0)
            pq.offer(new Pair(b, 'b'));
        if (c > 0)
            pq.offer(new Pair(c, 'c'));

        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            if (res.length() >= 2 && res.charAt(res.length() - 1) == curr.ch
                    && res.charAt(res.length() - 2) == curr.ch) {
                if (pq.isEmpty())
                    break;
                Pair next = pq.poll();
                res.append(next.ch);
                next.count--;
                if (next.count > 0)
                    pq.offer(next);
            } else {
                res.append(curr.ch);
                curr.count--;
            }
            if (curr.count > 0)
                pq.offer(curr);
        }
        return res.toString();
    }

    class Pair {
        int count;
        char ch;

        Pair(int count, char ch) {
            this.count = count;
            this.ch = ch;
        }
    }
}