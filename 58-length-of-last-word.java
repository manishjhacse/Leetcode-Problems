class Solution {
    public int lengthOfLastWord(String s) {
        int n = s.length() - 1;
        int count = 0;
        boolean wordFound = false;
        while (n >= 0) {
            if (s.charAt(n) == ' ' && !wordFound) {
                n--;
            } else if (s.charAt(n) == ' ' && wordFound) {
                break;
            } else {
                wordFound = true;
                count++;
                n--;
            }
        }
        return count;

    }
}