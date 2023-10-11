class Solution {
    public int mostWordsFound(String[] sentences) {
        int n = sentences.length, max_count = 0;
        for(int i=0;i<n;i++){
            int count = countWords(sentences[i],sentences[i].length());
            max_count = Math.max(count,max_count);
        }
        return max_count;
    }

    public int countWords(String str, int n){
        int i = 0, count = 0;
        while(i<n){
            if(str.charAt(i)==' '){
                count++;
            }
            i++;
        }
        count++;
        return count;
    }

}