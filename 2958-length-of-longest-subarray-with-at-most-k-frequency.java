class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int start=0,end=0;
        int maxlength=1;
        while (end<nums.length) {
            int freq=map.getOrDefault(nums[end], 0);
            if(freq<k){
                map.put(nums[end], freq+1);
                end++;
            }else{
                while (nums[start]!=nums[end]) {
                    int val=map.get(nums[start]);
                    map.put(nums[start], val-1);
                    start++;
                }
                int val=map.get(nums[start]);
                map.put(nums[start], val-1);
                start++;
            }
            maxlength=Math.max(maxlength, end-start);
            
        }
        return maxlength;
    }
}
