class Solution {
    public double pow(double num, int power) {
        if (power == 0)
            return 1;
        double temp = pow(num, power / 2);
        if (power % 2 == 0) {
            return temp * temp;
        } else {

            return num * temp * temp;
        }

    }

    public double myPow(double x, int n) {
        double ans = pow(x, n);
        return n < 0 ? 1 / ans : ans;
    }
}