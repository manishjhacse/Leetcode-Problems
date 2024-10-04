class Solution {
    public long dividePlayers(int[] skill) {
        int teams = skill.length / 2;
        long res = 0;
        int totalSum = 0;
        int freq[] = new int[1001];
        for (int element : skill) {
            totalSum += element;
            freq[element]++;
        }
        if (totalSum % teams != 0) {
            return -1;
        }
        int pairSkill = totalSum / teams;
        for (int element : skill) {
            if (freq[element] == 0) {// already gone to a pair
                continue;
            }
            freq[element]--;
            int reqSkill = pairSkill - element;
            if (freq[reqSkill] == 0) {
                return -1;
            }
            freq[reqSkill]--;
            res += ((long) element * (long) reqSkill);
        }
        return res;
    }
}