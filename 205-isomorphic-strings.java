class Solution {
    public boolean isIsomorphic(String s, String t) {
        int arr[] = new int[256];
        Arrays.fill(arr, -1);
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (arr[charS] == -1) {
                arr[charS] = charT;
            }
            if (arr[charT + 128] == -1) {
                arr[charT + 128] = charS;
            }
            if (arr[charS] != charT || arr[charT + 128] != charS) {
                return false;
            }
        }
        return true;
    }
}
