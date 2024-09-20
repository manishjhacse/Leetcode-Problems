class Solution {
    public int[] lbs(int n, String s) {
        int i = 0, j = 1;
        int arr[] = new int[n];
        while (j < s.length()) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                arr[j] = i;
                j++;
            } else {
                if (i == 0) {
                    j++;
                } else {
                    i = arr[i - 1];
                }
            }
        }
        return arr;
    }

    public String shortestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s).reverse();
        StringBuilder sb1 = new StringBuilder();
        sb1.append(s).append("#").append(sb.toString());
        int n = sb1.length();
        int arr[];
        arr = lbs(n, sb1.toString());
        int i = arr[arr.length - 1];
        StringBuilder sb2 = new StringBuilder();
        sb2.append(s.substring(i)).reverse();
        return sb2.toString() + s;

    }
}