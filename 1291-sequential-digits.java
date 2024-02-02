import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=9;i++){
            int temp=i;
            for(int j=i+1;j<=9;j++){
                temp=temp*10+j;
                if(temp>=low && temp<=high){
                    ans.add(temp);
                }
                if(temp>high)
                break;
            }
        }
        Collections.sort(ans);
        return ans;

    }
}