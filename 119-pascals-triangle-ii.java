import java.util.ArrayList;
import java.util.List;

class Solution {
    public static int combination(int n,int r){
        long res=1;
        for(int i=0;i<r;i++){
            res=res*(long)(n-i);
            res=res/(long)(i+1);
        }
        return (int)res;
    }
    public List<Integer> getRow(int rowIndex) {
      List<Integer> ans=new ArrayList<>();
      for(int i=0;i<=rowIndex;i++){
        ans.add(combination(rowIndex, i));
      }
      return ans;
    }
}