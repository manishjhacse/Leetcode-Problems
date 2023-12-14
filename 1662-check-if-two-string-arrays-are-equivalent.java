class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String left = ""; // Initialize left and right to empty strings
        String right = "";

        for (int i = 0; i < word1.length; i++) {
            left += word1[i];
        }

        for (int i = 0; i < word2.length; i++) {
            right += word2[i];
        }

        return left.equals(right);
    }
}