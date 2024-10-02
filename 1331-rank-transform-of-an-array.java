class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int sortedArr[] =new int[n];
        for(int i=0;i<n;i++){
            sortedArr[i]=arr[i];
        }
        Arrays.sort(sortedArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(sortedArr[i], map.size() + 1);
        }
        int res[] = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }
}