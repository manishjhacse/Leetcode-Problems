class Solution {
    public int maximumSwap(int num) {
        char numArr[] = Integer.toString(num).toCharArray();
        int n = numArr.length;
        int maxIndex = n - 1;
        char maxElement = numArr[maxIndex];
        int swapIndex_1 = -1;
        int swapIndex_2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (numArr[i] > maxElement) {
                maxElement = numArr[i];
                maxIndex = i;
            } else if (numArr[i] < maxElement) {
                swapIndex_1 = i;
                swapIndex_2 = maxIndex;
            }
        }
        if (swapIndex_1 != -1) {
            char temp = numArr[swapIndex_1];
            numArr[swapIndex_1] = numArr[swapIndex_2];
            numArr[swapIndex_2] = temp;
        }
        return Integer.parseInt(new String(numArr));
    }
}