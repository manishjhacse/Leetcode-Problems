import java.util.PriorityQueue;

class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double[] a, double[] b) {
                if (a[0] <= b[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            double primeFactorization = 1.0 * arr[i] / arr[n - 1];
            pq.offer(new double[] { primeFactorization, i, n - 1 });
        }
        int ans[] = new int[2];
        while (k > 0) {
            double curArr[] = pq.poll();
            int numIndex = (int) curArr[1];
            int denIndex = (int) curArr[2];
            int nextDenIndex = denIndex - 1;
            if (numIndex < nextDenIndex) {
                double primeFactorization = 1.0 * arr[numIndex] / arr[nextDenIndex];
                pq.offer(new double[] { primeFactorization, numIndex, nextDenIndex });
            }
            k--;
            if (k == 0) {
                ans[0] = arr[numIndex];
                ans[1] = arr[denIndex];
            }
        }
        return ans;
    }
}
