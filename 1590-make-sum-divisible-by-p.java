class Solution {
    public int minSubarray(int[] nums, int p) {
        long sum = 0;
        int n = nums.length;
        for (int num : nums) {
            sum += num;
        }
        long rem=sum%p;
        if (rem == 0) {
            return 0;
        }
        HashMap<Long,Integer> map=new HashMap<>();
        map.put(0l,-1);
        int minCount = n;
        sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
            sum%=p;
            long tempRem=sum-rem;
            if(tempRem<0){
                tempRem+=p;
            }
            if(map.get(tempRem)!=null){
                minCount=Math.min(minCount,i-map.get(tempRem));
            }
            map.put(sum,i);
        }
        return minCount==n?-1:minCount;
    }
}