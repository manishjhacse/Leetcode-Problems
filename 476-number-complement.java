class Solution {
    public int findComplement(int num) {
        int noOfBits = (int) (Math.log10(num) / Math.log10(2)) + 1;
        int ones = (1 << noOfBits) - 1;
        return ones ^ num;
    }
}