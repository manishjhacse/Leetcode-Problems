class Solution {
    public int getLucky(String s, int k) {
        StringBuilder str = new StringBuilder();
        int sum1 = 0;
        for (char ch : s.toCharArray()) {
            int digit = ch - 96;
            while (digit > 0) {
                sum1 += (digit % 10);
                digit /= 10;
            }
        }
        str.append(sum1);
        while (k > 1) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                sum += str.charAt(i) - '0';
            }
            str = new StringBuilder(String.valueOf(sum));
            k--;
        }
        return Integer.parseInt(str.toString());

    }
}