import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // int index = 0;
        // int[] sums = new int[n * (n + 1) / 2];

        // for (int i = 0; i < n; i++) {
        // int sum = 0;
        // for (int j = i; j < n; j++) {
        // sum += nums[j];
        // sums[index++] = sum;
        // }
        // }

        // int res = 0, mod = 1000000007;
        // Arrays.sort(sums);
        // for (int i = left - 1; i < right; i++) {
        // res = (res + sums[i]) % mod;
        // }

        // return res;
        int sum = 0;
        int mod = 1000000007;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int a[], int b[]) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new int[] { nums[i], i });
        }
        for (int i = 0; i < right; i++) {
            int curr[] = pq.poll();
            if (i >= left - 1) {
                sum = (sum + curr[0]) % mod;
            }
            if (curr[1] + 1 < n) {
                curr[1]++;
                curr[0] += nums[curr[1]];
                pq.offer(curr);
            }
        }
        return sum;
    }
}