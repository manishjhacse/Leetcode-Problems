class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String smallerArr[];
        String largerArr[];
        if (sentence1.length() < sentence2.length()) {
            smallerArr = sentence1.split(" ");
            largerArr = sentence2.split(" ");
        } else {
            smallerArr = sentence2.split(" ");
            largerArr = sentence1.split(" ");
        }
        int start = 0;
        int endSmall = smallerArr.length - 1, endLarger = largerArr.length - 1;
        while (start <= endSmall && smallerArr[start].equals(largerArr[start])) {
            start++;
        }
        while (start <= endSmall && smallerArr[endSmall].equals(largerArr[endLarger])) {
            endLarger--;
            endSmall--;
        }
        if (start > endSmall) {
            return true;
        } else {
            return false;
        }
    }
}