class Solution {
    public String removeOuterParentheses(String s) {
        String ans="";
        int count=0,flag=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='(')
            count++;
            else
            count--;
            if(count==0 || (flag!=count && count==1)){
                flag=count;
                continue;
            }
            else{
                ans+=ch;
            }
            

        }
        return ans;
    }
}