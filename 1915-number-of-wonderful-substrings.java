class Solution {
    public long wonderfulSubstrings(String word) {
        int length = word.length();
        Map<Integer, Integer> frequency = new HashMap<>();
        frequency.put(0, 1);
        int mask = 0;
        long result = 0L;
        for (int index = 0; index < length; index++) {
            char character = word.charAt(index);
            int bit = character - 'a';
            mask ^= (1 << bit);
            result += frequency.getOrDefault(mask, 0);
            frequency.put(mask, frequency.getOrDefault(mask, 0) + 1);
            for (int oddCharacter = 0; oddCharacter < 10; oddCharacter++) {
                result += frequency.getOrDefault(mask ^ (1 << oddCharacter), 0);
            }
        }
        return result;

    }
}
