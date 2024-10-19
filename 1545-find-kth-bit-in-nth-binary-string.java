class Solution {
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int mid = (1 << (n - 1)) - 1;  
        
        if (k <= mid) {
            return findKthBit(n - 1, k);
        } else if (k == mid + 1) {
            return '1';
        } else {
            char bit = findKthBit(n - 1, (1 << n) - k);
            return (bit == '0') ? '1' : '0';
        }
    }
}