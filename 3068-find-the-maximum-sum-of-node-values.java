class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<Integer>[] adjacencyList = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            adjacencyList[edges[i][0]].add(edges[i][1]);
            adjacencyList[edges[i][1]].add(edges[i][0]);
        }
        List<Integer> increaseList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long xorValue = (long) nums[i] ^ k;
            if (xorValue > nums[i]) {
                increaseList.add(i);
            }
        }

        int increaseListSize = increaseList.size();
        if (increaseListSize % 2 == 0) {
            long answer = 0;
            for (int num : nums) {
                answer += num;
            }
            for (Integer index : increaseList) {
                answer -= nums[index];
                long add = (long) nums[index] ^ k;
                answer += add;
            }
            return answer;
        } else {
            long answer = 0;
            for (int num : nums) {
                answer += (long) num;
            }
            long maxSum = answer;
            for (Integer index : increaseList) {
                answer -= nums[index];
                long add = (long) nums[index] ^ k;
                answer += add;
            }
            for (Integer index : increaseList) {
                long add = (long) nums[index] ^ k;
                long currentAnswer = answer - add + nums[index];
                maxSum = Math.max(maxSum, currentAnswer);
            }
            List<Integer> visited = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                visited.add(0);
            }
            long sum = 0;
            for (Integer index : increaseList) {
                visited.set(index, 1);
            }
            for (int i = 0; i < n; i++) {
                if (visited.get(i) == 0) {
                    long add = (long) nums[i] ^ k;
                    long currentAnswer = answer - nums[i] + add;
                    maxSum = Math.max(maxSum, currentAnswer);
                }
            }
            return maxSum;
        }
    }
}