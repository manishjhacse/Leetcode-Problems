class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int ans=0;
        // int leftMax[]=new int[n];
        // int rightMax[]=new int[n];
        // leftMax[0]=height[0];
        // rightMax[n-1]=height[n-1];
        // for(int i=1;i<n;i++){
        //     leftMax[i]=leftMax[i-1]>height[i]?leftMax[i-1]:height[i];
        // }
        // for(int i=n-2;i>=0;i--){
        //     rightMax[i]=rightMax[i+1]>height[i]?rightMax[i+1]:height[i];
        // }
        // for(int i=0;i<n;i++){
        //     ans=Math.min(leftMax[i],rightMax[i])-height[i]+ans;
        // }

        /*-------------------------------- */
        int leftMax=0;
        int rightMax=0;
        int start=0,end=height.length-1;
        while (start<end) {
            if(leftMax<height[start]){
                leftMax=height[start];
            }
            if(rightMax<height[end]){
                rightMax=height[end];
            }
            if(leftMax<rightMax){
                ans=(leftMax-height[start])+ans;
                start++;
            }else{
                ans=(rightMax-height[end])+ans;
                end--;
            }

        }
        return ans;
    }
}