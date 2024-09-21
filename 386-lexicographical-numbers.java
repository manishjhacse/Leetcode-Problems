import java.util.ArrayList;
import java.util.List;

class Solution {
    public void dfs(int curNum, int n, List<Integer> res) {
        if (curNum > n) {
            return;
        }
        res.add(curNum);
        for (int i = 0; i < 10; i++) {
            if (curNum * 10 + i > n) {
                break;
            }
            dfs(curNum * 10 + i, n, res);
        }
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            if (i > n) {
                break;
            }
            dfs(i, n, res);
        }
        return res;
    }
}