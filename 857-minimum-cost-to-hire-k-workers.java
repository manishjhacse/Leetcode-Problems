import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        ArrayList<double[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            double ratio = 1.0 * wage[i] / quality[i];
            list.add(new double[] { ratio, quality[i] });
        }
        Collections.sort(list, new Comparator<double[]>() {
            public int compare(double a[], double b[]) {
                if (a[0] < b[0]) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });
        PriorityQueue<double[]> pq = new PriorityQueue<>(new Comparator<double[]>() {
            public int compare(double a[], double b[]) {
                if (a[1] < b[1]) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        int totalQuality = 0;
        double minCost = Double.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            double arr[] = list.get(i);
            pq.offer(arr);
            totalQuality += arr[1];
            if (pq.size() == k) {
                double minWage = arr[0];
                minCost = Math.min(minCost, minWage * totalQuality);
                totalQuality -= pq.poll()[1];

            }
        }
        return minCost;
    }

}