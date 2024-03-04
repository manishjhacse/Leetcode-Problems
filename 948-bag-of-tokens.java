class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int score=0;
        int start=0,end=tokens.length-1;
        while(start<=end){
            if(power>=tokens[start]){
                power-=tokens[start++];
                score++;
            }
            else{
                if(score>0 && start!=end){
                    score--;
                    power+=tokens[end--];
                }
                else{
                    break;
                }
            }
        }
        return score;
    }
}