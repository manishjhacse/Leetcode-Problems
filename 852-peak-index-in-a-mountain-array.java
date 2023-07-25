class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n=arr.length;
        int l=1,r=n-2;
        int mid=-1;
        while(l<=r)
        {
            mid=l+(r-l)/2;
            if(arr[mid-1]<arr[mid] && arr[mid+1]<arr[mid])
            {
                break;
            }
            else if(arr[mid-1]>arr[mid] && arr[mid+1]<arr[mid])
            {
                r=mid-1;
            }
            else
            {
                l=mid+1;
            }
        }
        return mid;
    }
}