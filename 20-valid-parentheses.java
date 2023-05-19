class Solution {
    public boolean isValid(String s) {
        
            //Approach: using Stack
            Stack<Character> st = new Stack<>();
    
            //iterate through the given string add to stack
            for(char a:s.toCharArray()){
                // char a = s.charAt(i);
                if(a==\'(\' || a==\'{\' || a==\'[\'){
                    st.push(a);
                }
                //remove
               else if(a==\')\' && !st.empty() && st.peek()==\'(\') st.pop();
                else if(a==\'}\' && !st.empty() && st.peek()==\'{\') st.pop();
                else if(a==\']\' && !st.empty() && st.peek()==\'[\') st.pop();
                else return false;
            }
            return st.empty();
    }
}