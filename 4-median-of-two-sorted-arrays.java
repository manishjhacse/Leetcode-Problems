class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
       int n=nums1.length,m=nums2.length;
       int len=n+m;
       int ind1=len/2;
       int ind2=len/2-1;
       int cnt=0,i=0,j=0;
       int ele1=-1,ele2=-1;
       while(i<n && j<m){
        if(nums1[i]<nums2[j]){
            if(cnt==ind1)
            ele1=nums1[i];
            if(cnt==ind2)
            ele2=nums1[i];
            i++;
            cnt++;
        }
        else{
            if(cnt==ind1)
            ele1=nums2[j];
            if(cnt==ind2)
            ele2=nums2[j];
            j++;
            cnt++;
        }
       }
       while(i<n){
         if(cnt==ind1)
            ele1=nums1[i];
            if(cnt==ind2)
            ele2=nums1[i];
            i++;
            cnt++;
       }
       while(j<m){
         if(cnt==ind1)
            ele1=nums2[j];
            if(cnt==ind2)
            ele2=nums2[j];
            j++;
            cnt++;
       }
       
       if(len%2==1){
        return (double)ele1;
       }
       else{
        return ((double)ele1+(double)ele2)/2;
       }
    }
}