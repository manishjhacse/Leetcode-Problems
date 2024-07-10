class Solution {
    public int minOperations(String[] logs) {
        int minRequiredOperation = 0;
        for (String str : logs) {
            if (str.equals("../")) {
                if (minRequiredOperation > 0) {
                    minRequiredOperation--;
                }
            } else if (str.equals("./")) {
                continue;
            } else {
                minRequiredOperation++;
            }
        }
        return minRequiredOperation;
    }
}