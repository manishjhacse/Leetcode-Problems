class Solution {
    public int compareVersion(String version1, String version2) {
        int n1 = 0, n2 = 0;
        while (n1 < version1.length() || n2 < version2.length()) {
            int v1 = 0, v2 = 0;
            while (n1 < version1.length() && version1.charAt(n1) != '.') {
                v1 += v1 * 10 + (version1.charAt(n1) - '0');
                n1++;
            }
            while (n2 < version2.length() && version2.charAt(n2) != '.') {
                v2 += v2 * 10 + (version2.charAt(n2) - '0');
                n2++;
            }
            if (v1 < v2)
                return -1;
            if (v1 > v2)
                return 1;
            n1++;
            n2++;

        }
        return 0;
    }
}