class Solution {
    public static boolean isDigit(char ch) {// function to check chacater is digit or not
        if ((ch - '0') >= 0 && (ch - '0') <= 9)
            return true;
        else
            return false;
    }

    public int myFuntion(String s, int ans, char sign) {
        if (s.isEmpty()) {
            if (sign == '-') {
                ans = 0 - ans;
            }
            return ans;
        }
        char firstCh = s.charAt(0);
        if (!(isDigit(firstCh))) {// if character is not a digit
            if (ans != 0) {// if ans not zero then return the ans
                if (sign == '-') {
                    ans = 0 - ans;
                }
                return ans;
            } else { // if ans is zero
                if (sign != '_') {// this will ensure that the sign will change only once
                    return 0;
                }
                if (firstCh != '-' && firstCh != '+' && firstCh != ' ') {
                    if (sign == '-') {
                        ans = 0 - ans;
                    }
                    return ans;
                }
                if (firstCh == '-') {
                    sign = '-';
                }
                if (firstCh == '+')
                    sign = '+';
            }
        } else {
            int digit = (firstCh - '0');
            if (sign == '_' && digit == 0) {// we are doing this as a sign value can we after 0 so we will avoid this
                                            // condition
                sign = '0';
            }
            if (ans > (Integer.MAX_VALUE - digit) / 10) {
                if (sign == '-') {
                    return -2147483648;
                } else {
                    return 2147483647;
                }
            }
            ans = ans * 10 + digit;
        }
        return myFuntion(s.substring(1), ans, sign);
    }

    public int myAtoi(String s) {
        int ans = myFuntion(s, 0, '_');
        return ans;
    }
}