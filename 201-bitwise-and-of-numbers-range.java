class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int shift_right=0;
        while(left!=right){
            left=left>>1;
            right=right>>1;
            shift_right++;
        }
        return left<<shift_right;
    }
}