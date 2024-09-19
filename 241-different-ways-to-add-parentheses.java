import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> ways(String exp, int start, int end,List<Integer>[][]dp) {
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        List<Integer> list = new ArrayList<>();
        if (start == end) {
            int n = exp.charAt(start) - '0';
            list.add(n);
            return list;
        }
        if (end - start == 1 && Character.isDigit(exp.charAt(start))) {
            int n = Integer.parseInt(exp.substring(start, end + 1));
            list.add(n);
            return list;
        }
        for (int i = start; i <= end; i++) {
            if (Character.isDigit(exp.charAt(i))) {
                continue;
            }
            char operator = exp.charAt(i);
            List<Integer> left = ways(exp, start, i - 1,dp);
            List<Integer> right = ways(exp, i + 1, end,dp);
            for (int l : left) {
                for (int r : right) {
                    if (operator == '*') {
                        list.add(l * r);
                    } else if (operator == '+') {
                        list.add(l + r);
                    } else {
                        list.add(l - r);
                    }
                }
            }
        }
        dp[start][end]=list;
        return list;
    }

    public List<Integer> diffWaysToCompute(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];
        return ways(expression, 0, n - 1, dp);
    }
}