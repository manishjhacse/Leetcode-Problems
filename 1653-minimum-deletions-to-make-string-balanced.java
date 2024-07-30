class Solution {
    public int minimumDeletions(String s) {
        // int freqA = 0;
        // int freqB = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == 'a') {
        //         freqA++;
        //     }
        // }
        // int ans = Integer.MAX_VALUE;
        // int currA = 0;
        // for (int i = 0; i < s.length(); i++) {
        //     if (s.charAt(i) == 'a') {
        //         currA++;
        //     }
        //     ans = Math.min(ans, (freqA - currA) + freqB);
        //     if (s.charAt(i) == 'b') {
        //         freqB++;
        //     }
        // }
        // return ans;
        int ans=0,bCount=0;
        for(char ch:s.toCharArray()){
            if(ch=='b'){
                bCount++;
            }else if(bCount>0){
                ans++;
                bCount--;
            }
        }
        return ans;

    }
}