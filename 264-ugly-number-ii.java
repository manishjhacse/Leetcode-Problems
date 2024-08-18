class Solution {
    public int nthUglyNumber(int n) {
        int ugly[] = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for (int i = 1; i < n; i++) {
            ugly[i] = Math.min(factor2, Math.min(factor3, factor5));
            if (ugly[i] == factor2)
                factor2 = 2 * ugly[++index2];
            if (ugly[i] == factor3)
                factor3 = 3 * ugly[++index3];
            if (ugly[i] == factor5)
                factor5 = 5 * ugly[++index5];
        }
        return ugly[n - 1];
    }
}