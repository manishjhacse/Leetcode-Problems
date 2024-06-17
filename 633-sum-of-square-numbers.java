class Solution {
    public boolean judgeSquareSum(int c) {
        long end = (long) Math.sqrt(c);
        long start = 0;
        while (start <= end) {
            long square = start * start + end * end;
            if (square == c) {
                return true;
            } else if (square > c) {
                end--;
            } else {
                start++;
            }
        }
        return false;
    }
}