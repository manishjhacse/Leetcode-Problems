class Solution {
    public int lengthOfLastWord(String s) {
     int count=0;
     int last=s.length()-1;
     for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)==' '){
            last--;
        }else{
            break;
        }
     }   
      for(int i=last;i>=0;i--){
        if(s.charAt(i)==' '){
            break;
        }
        count++;
     }  
     return count;
    }
}