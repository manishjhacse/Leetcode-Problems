class Solution {
    public String maximumOddBinaryNumber(String s) {
    int len = s.length();
    int one = 0, zero = 0;
    
    for (int i = 0; i < len; i++) {
        if (s.charAt(i) == '1') {
            one++;
        } else {
            zero++;
        }
    }
    
    if (one == 0) {
        return s;
    }
    StringBuilder string = new StringBuilder(s);
    
     for(int i=0;i<one-1;i++){
            string.setCharAt(i, '1');
     }   
        for(int i=one-1;i<len;i++){
            string.setCharAt(i, '0');
        }
        
        string.setCharAt(len-1,'1');
    
    return string.toString();
}

        
        
 }