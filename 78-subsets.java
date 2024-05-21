import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        backtrackSubset(answer, new ArrayList<>(), nums, 0);
        return answer;
    }

    public void backtrackSubset(List<List<Integer>> answer, List<Integer> tempSet, int nums[], int index) {
        if (nums.length == index) {
            answer.add(new ArrayList<>(tempSet));
            return;
        }
        tempSet.add(nums[index]);
        backtrackSubset(answer, tempSet, nums, index + 1);
        tempSet.remove(tempSet.size() - 1);
        backtrackSubset(answer, tempSet, nums, index + 1);

    }
}