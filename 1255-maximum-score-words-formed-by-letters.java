class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int[] lettersFreq = new int[26];
        for (char letter : letters) {
            lettersFreq[letter - 'a']++;
        }
        
        return backtrack(words, lettersFreq, score, 0);
    }

    private int backtrack(String[] words, int[] lettersFreq, int[] score, int idx) {
        if (idx == words.length) {
            return 0;
        }

        int skip = backtrack(words, lettersFreq, score, idx + 1);

        int[] wordFreq = new int[26];
        int wordScore = 0;
        boolean canForm = true;

        for (char c : words[idx].toCharArray()) {
            int code = c - 'a';
            wordFreq[code]++;
            if (wordFreq[code] > lettersFreq[code]) {
                canForm = false;
            }
            wordScore += score[code];
        }

        int use = 0;
        if (canForm) {
            for (char c : words[idx].toCharArray()) {
                lettersFreq[c - 'a']--;
            }
            use = wordScore + backtrack(words, lettersFreq, score, idx + 1);
            for (char c : words[idx].toCharArray()) {
                lettersFreq[c - 'a']++;
            }
        }

        return Math.max(skip, use);
    }
}