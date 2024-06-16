class Solution {
    public int minPatches(int[] nums, int n) {
        long sumGenerated=0;
        long expectedSum=1;
        int minPatchesRequired=0;
        int i=0;
        while (sumGenerated<n) {
            if(sumGenerated>=expectedSum){
                expectedSum=sumGenerated+1;;
            }else{
                if(i<nums.length && nums[i]<=expectedSum){
                    sumGenerated+=nums[i];
                    i++;
                }else{
                    sumGenerated+=expectedSum;
                    minPatchesRequired++;
                }
            }
        }
        return minPatchesRequired;
    }
}