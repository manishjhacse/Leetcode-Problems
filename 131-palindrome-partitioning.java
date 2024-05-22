import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> palindromeList = new ArrayList<>();

    public boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public void palindrome_partition(String s, int partitionIndex, List<String> tempList) {
        if (partitionIndex == s.length()) {
            palindromeList.add(new ArrayList<>(tempList));
            return;
        }
        for (int end = partitionIndex; end < s.length(); end++) {
            if (isPalindrome(s, partitionIndex, end)) {
                tempList.add(s.substring(partitionIndex, end + 1));
                palindrome_partition(s, end + 1, tempList);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        palindrome_partition(s, 0, new ArrayList<>());
        return palindromeList;
    }
}