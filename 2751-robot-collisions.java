import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        List<Integer> ans = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();
        Integer indexes[] = new Integer[n];
        for (int i = 0; i < n; i++) {
            indexes[i] = i;
        }
        Arrays.sort(indexes, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return positions[a] - positions[b];
            }
        });

        for (int index : indexes) {
            if (directions.charAt(index) == 'R') {
                stack.add(index);
            } else {
                boolean isSurvived = true;
                while (!stack.isEmpty()) {
                    int top = stack.get(stack.size() - 1);
                    if (directions.charAt(top) == 'L') {
                        isSurvived = true;
                        break;
                    } else if (healths[top] > healths[index]) {
                        isSurvived = false;
                        healths[index] = 0;
                        healths[top]--;
                        break;
                    } else if (healths[top] < healths[index]) {
                        isSurvived = true;
                        healths[top] = 0;
                        healths[index]--;
                        stack.remove(stack.size() - 1);
                    } else {
                        isSurvived = false;
                        healths[top] = 0;
                        healths[index] = 0;
                        stack.remove(stack.size() - 1);
                        break;
                    }
                }
                if (isSurvived) {
                    stack.add(index);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                ans.add(healths[i]);
            }
        }
        return ans;
    }
}