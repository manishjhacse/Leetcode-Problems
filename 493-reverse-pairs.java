import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void merge(int nums[],int low,int mid,int high){
        int left=low,right=mid+1;
        List<Integer> temp=new ArrayList<>();
        while(left<=mid && right<=high){
            if(nums[left]<=nums[right]){
                temp.add(nums[left]);
                left++;
            }
            else{
                temp.add(nums[right]);
                right++;
            }
        }
          while (left <= mid) {
            temp.add(nums[left]);
            left++;
        }
        while (right <= high) {
            temp.add(nums[right]);  
            right++;         
        }
        for(int i=low;i<=high;i++){
            nums[i] = temp.get(i - low);
        }
    }
    public static int count(int nums[],int low,int mid,int high){
        int cnt=0;
        int right=mid+1;
       for(int i=low;i<=mid;i++){
        while(right<=high && (long)nums[i]>(long)nums[right]*2){
            right++;
        }
        cnt=cnt+(right-(mid+1));
       }
       
       return cnt;
    }
    public static int mergeSort(int nums[],int low,int high){
        int cnt=0;
        if(low>=high)
        return cnt ;
        int mid=low+(high-low)/2;
        cnt+=mergeSort(nums, low, mid);
        cnt+=mergeSort(nums, mid+1, high);
        cnt+=count(nums, low, mid, high);
        merge(nums,low,mid,high);   
        return cnt; 
    }
    public int reversePairs(int[] nums) {
       int noOfPairs=mergeSort(nums, 0, nums.length-1);
        
        return noOfPairs;
    }
}