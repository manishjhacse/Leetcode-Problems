import java.util.ArrayList;
import java.util.List;

class Solution {
    // public static int combination(int n,int r){
    //     int ans=1;
    //     for(int i=0;i<r;i++){
    //         ans=ans*(n-i);
    //         ans=ans/(i+1);
    //     }
    //     return ans;
    // }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        // for(int i=0;i<numRows;i++){
        //     List<Integer> temp=new ArrayList<>();
        //     for(int j=0;j<=i;j++){
        //         int val=combination(i,j);
        //         temp.add(val);
        //     }
        //     ans.add(temp);
        // }
        if(numRows==0)
        return ans;
        List<Integer> firstRow=new ArrayList<>();
        firstRow.add(1);
        ans.add(firstRow);
        for(int i=1;i<numRows;i++){
            List<Integer>prevRow=ans.get(i-1);
            List<Integer>row=new ArrayList<>();
            row.add(1);
            for(int j=0;j<i-1;j++){
                row.add(prevRow.get(j)+prevRow.get(j+1));
            }
            row.add(1);
            ans.add(row);
        }

        return ans;
    }
}