class Solution {
    public boolean checkValidString(String s) {
        List<Integer>openBracet=new ArrayList<>();
        List<Integer>aestric=new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openBracet.add(i);
            } else if (ch == '*') {
               aestric.add(i);
            }else{
               int openBracetLength=openBracet.size();
               int aestricLength=aestric.size();
               if(openBracetLength>0){
                openBracet.remove(openBracetLength-1);
               }else if(aestricLength>0){
                aestric.remove(aestricLength-1);
               }else{
                return false;
               }
            }
        }

        while (!openBracet.isEmpty()) {
            if(aestric.isEmpty()){
                return false;
            }
            int openBracetLength=openBracet.size();
            int aestricLength=aestric.size();
            int open=openBracet.remove(openBracetLength-1);
            int close=aestric.remove(aestricLength-1);
            if(open>close){
                return false;
            }
            
        }
        return true;
    }
}