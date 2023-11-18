import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrackSubset(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    public void backtrackSubset(List<List<Integer>> answer, List<Integer> tempSet, int nums[], int start) {
        answer.add(new ArrayList<>(tempSet));
        for (int i = start; i < nums.length; i++) {
            tempSet.add(nums[i]);
            backtrackSubset(answer, tempSet, nums, i + 1);
            tempSet.remove(tempSet.size() - 1);
        }
    }
}