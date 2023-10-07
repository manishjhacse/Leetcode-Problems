class Solution {
    public static boolean isPossible(int arr[], int day, int m, int k) {
        int count = 0, bouq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= day) {
                count++;
            } else {
                bouq = bouq + (count / k);
                count = 0;
            }
        }
        bouq = bouq + (count / k);
        if (bouq >= m)
            return true;
        else
            return false;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int min=bloomDay[0],max=bloomDay[0];
        if((double)bloomDay.length<(double)m*k)
        return -1;
        for(int i=0;i<bloomDay.length;i++){
            if(min>bloomDay[i]){
                min=bloomDay[i];
            }
            if(bloomDay[i]>max){
                max=bloomDay[i];
            }
        }
       while(min<=max)
       {
        int mid=min+(max-min)/2;
        if(isPossible(bloomDay, mid, m, k)){
            max=mid-1;
        }
        else{
            
            min=mid+1;
       }
    }
    return min;
}
}