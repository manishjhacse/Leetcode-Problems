public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] taskFreq = new int[26];
        for (char task : tasks) {
            taskFreq[task - 'A']++;
        }
        
        int maxFreq = 0;
        int maxCount = 0;
        
        for (int freq : taskFreq) {
            maxFreq = Math.max(maxFreq, freq);
        }
        
        for (int freq : taskFreq) {
            if (freq == maxFreq) {
                maxCount++;
            }
        }
        
        int partCount = maxFreq - 1;
        int partLength = n - (maxCount - 1);
        int emptySlots = partCount * partLength;
        int availableTasks = tasks.length - maxFreq * maxCount;
        int totalIdle = Math.max(0, emptySlots - availableTasks);
        
        return tasks.length + totalIdle;
    }
}