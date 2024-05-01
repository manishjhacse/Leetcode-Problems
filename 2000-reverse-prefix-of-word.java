class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder reversedWord = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char wordCh = word.charAt(i);
            reversedWord.insert(0, wordCh);
            if (wordCh == ch) {
                reversedWord.append(word.substring(i + 1));
                return reversedWord.toString();
            }

        }
        return word;
    }
}