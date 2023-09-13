class Solution {
       public static int binarySearch(int A[],int l,int h,int key){
        
        if(h<l)
        return -1;
        int mid=l+(h-l)/2;
        if(A[mid]==key)
        return mid;
        if(A[mid]>key)
        return binarySearch(A,l,mid-1,key);
        else
        return binarySearch(A,mid+1,h,key);
    }
       public static int findPivot(int A[],int l,int h){
        if(h<l)
        return -1;
        int m=l+(h-l)/2;
        if(m<h&&A[m]>A[m+1])
        return m;
        if(m>l&&A[m-1]>A[m])
        return m-1;
        if(A[l]>=A[m])
        return findPivot(A,l,m-1);
        else
        return findPivot(A,m+1,h);
    }
    public int search(int[] nums, int target) {
        int l=0;
        int h=nums.length-1;
        int pivot=findPivot(nums,l,h);
        if(pivot==-1){
            return binarySearch(nums,l,h,target);
        }
        if(nums[pivot]==target){
            return pivot;
        }
        if(target>=nums[l]){
            return binarySearch(nums,l,pivot-1,target);
        }
        else{
            return binarySearch(nums,pivot+1,h,target);
        }
    }

}
    
