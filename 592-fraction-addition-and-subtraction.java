import java.util.ArrayList;

class Solution {
    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        return gcd(b % a, a);
    }

    public String fractionAddition(String expression) {
        int numerator = 0;
        int denominator = 1;
        int n = expression.length();
        int i = 0;
        while (i < n) {
            int currNumerator = 0;
            int currDenominator = 0;
            boolean isNegative = false;
            char ch = expression.charAt(i);
            if (ch == '+' || ch == '-') {
                if (ch == '-')
                    isNegative = true;
                i++;
            }
            int start = i;
            while (Character.isDigit(expression.charAt(i))) {
                i++;
            }
            currNumerator = Integer.parseInt(expression.substring(start, i));
            if (isNegative) {
                currNumerator *= -1;
            }
            start = ++i;
            while (i < n && Character.isDigit(expression.charAt(i))) {
                i++;
            }
            currDenominator = Integer.parseInt(expression.substring(start, i));
            numerator = numerator * currDenominator + currNumerator * denominator;
            denominator *= currDenominator;
        }
        int gcd = Math.abs(gcd(numerator, denominator));
        numerator = numerator / gcd;
        denominator = denominator / gcd;
        return numerator + "/" + denominator;
    }
}