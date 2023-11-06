class Solution {
    public int addDigits(int num) {
     int res;
      res=num==0 ? 0:(num%9==0? 9 :num%9);
     return res;  
    }
}