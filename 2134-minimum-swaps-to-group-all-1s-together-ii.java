class Solution {
    public int minSwaps(int[] nums) {
        return Math.min(findMinSwaps(nums, 0), findMinSwaps(nums, 1));
    }
    private int findMinSwaps(int nums[], int val){
        int valCnt = 0, len = nums.length;
        for(var num : nums)if(num == val)valCnt++;
        int left = 0, right = 0, windowSize = valCnt;
        int oppValsInCurrWindow = 0, opsVal = (val == 1) ? 0 : 1;
        while(right < windowSize){
            if(nums[right++] == opsVal)oppValsInCurrWindow++;
        }
        int minOppValsInWindowsTillNow = oppValsInCurrWindow;
        while(right < (len)){
            if(nums[left++] ==  opsVal)oppValsInCurrWindow--;
            if(nums[right++] == opsVal) oppValsInCurrWindow++;
            minOppValsInWindowsTillNow = Math.min(minOppValsInWindowsTillNow, oppValsInCurrWindow);
        }
        return minOppValsInWindowsTillNow;
    }
}