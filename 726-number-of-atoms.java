import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;
import java.util.TreeMap;

class Solution {
    public String countOfAtoms(String formula) {
        List<HashMap<String, Integer>> stack = new ArrayList<>();
        stack.add(new HashMap<String, Integer>());
        int n = formula.length();
        int index = 0;

        while (index < n) {
            char ch = formula.charAt(index);
            if (ch == '(') {
                stack.add(new HashMap<String, Integer>());
                index++;
            } else if (ch == ')') {
                HashMap<String, Integer> map = stack.remove(stack.size() - 1);
                index++;
                StringBuilder multiplier = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    multiplier.append(formula.charAt(index));
                    index++;
                }
                int m = (multiplier.length() > 0) ? Integer.parseInt(multiplier.toString()) : 1;
                for (String atom : map.keySet()) {
                    map.put(atom, map.get(atom) * m);
                }
                for (String atom : map.keySet()) {
                    stack.get(stack.size() - 1).put(atom,
                            stack.get(stack.size() - 1).getOrDefault(atom, 0) + map.get(atom));
                }
            } else {
                StringBuilder atomName = new StringBuilder();
                atomName.append(ch);
                index++;
                while (index < n && Character.isLowerCase(formula.charAt(index))) {
                    atomName.append(formula.charAt(index));
                    index++;
                }
                StringBuilder count = new StringBuilder();
                while (index < n && Character.isDigit(formula.charAt(index))) {
                    count.append(formula.charAt(index));
                    index++;
                }
                int c = (count.length() > 0) ? Integer.parseInt(count.toString()) : 1;
                stack.get(stack.size() - 1).put(atomName.toString(),
                        stack.get(stack.size() - 1).getOrDefault(atomName.toString(), 0) + c);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>(stack.get(stack.size() - 1));
        StringBuilder res = new StringBuilder();
        for (String atom : sortedMap.keySet()) {
            res.append(atom);
            if (sortedMap.get(atom) > 1) {
                res.append(sortedMap.get(atom));
            }
        }
        return res.toString();
    }
}
