class Solution {
    public static int sumOddLengthSubarrays(int[] arr) {
       int windowSize = 1;
       int currentSum = 0;
       int finalSum = 0;

           for (windowSize = 1; windowSize <= arr.length ; windowSize+=2) {
               currentSum = sumOfAllSlidingWindowOfSizeK(arr , windowSize);
               finalSum += currentSum;
           }

       return finalSum;
   }
   public static int sumOfAllSlidingWindowOfSizeK(int[] arr , int k ) {
       int currSum = 0;
       int absSum = 0;
       //[1,]
           for (int j = 0; j < k; j++) {
               currSum += arr[j];
           }
           absSum += currSum;
           for (int j = k; j < j + k && j < arr.length; j++) {
               currSum = currSum - arr[j - k] + arr[j];
               absSum += currSum;
           }
       return absSum;
   }
}