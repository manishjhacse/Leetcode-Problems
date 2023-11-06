class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if(i>0 && nums[i]==nums[i-1])
            continue;
            for (int j = i + 1; j < n; j++) {
               int l=j+1,h=n-1;
               while(l<h){
                long sum=(long)nums[i]+(long)nums[j];
                sum+=(long)nums[l];
                sum+=(long)nums[h];
                if(sum>target){
                    h--;
                }
                else if(sum<target){
                    l++;
                }
                else{
                    List<Integer>temp=new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[l]);
                    temp.add(nums[h]);
                    set.add(temp);
                    l++;
                    h--;
                    while(l<h && nums[l]==nums[l-1])l++;
                    while(l<h && nums[h]==nums[h+1])h--;
                }

               }

            }
        }

        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}