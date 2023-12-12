class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
        
        int ans =0;
        for(int i =0;i<allowed.length();i++){
            set.add(allowed.charAt(i));
        }
        for(int i =0;i<words.length;i++){
            int count =0;
            for(int j =0;j<words[i].length();j++){
            if(!set.contains(words[i].charAt(j)))
            count ++;
           
            
            
        }
         if(count==0){
                ans ++;
            }
    
    
      
    }
    return ans;
}
}