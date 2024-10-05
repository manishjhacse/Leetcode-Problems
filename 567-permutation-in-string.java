class Solution {
    public boolean isSame(int arr1[], int arr2[]) {
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (m < n) {
            return false;
        }
        int arr1[] = new int[26];
        int arr2[] = new int[26];
        for (int i = 0; i < n; i++) {
            arr1[s1.charAt(i) - 'a']++;
            arr2[s2.charAt(i) - 'a']++;
        }
        if (isSame(arr1, arr2)) {
            return true;
        }
        for (int i = 1; i <= m - n; i++) {
            arr2[s2.charAt(i - 1) - 'a']--;
            arr2[s2.charAt(i + n - 1) - 'a']++;
            if (isSame(arr1, arr2)) {
                return true;
            }
        }
        return false;
    }
}