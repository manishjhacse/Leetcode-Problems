class Solution {
    public int minAddToMakeValid(String s) {
        int opening=0,closing=0;
        int count=0;
        for(char ch:s.toCharArray()){
            if(ch=='('){
                opening++;
            }else{
                closing++;
            }
            if(closing>opening){
                count++;
                opening++;
            }
        }
        return count+Math.abs(opening-closing);

    }
}