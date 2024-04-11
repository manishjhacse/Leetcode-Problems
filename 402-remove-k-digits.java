class Solution {
    public String removeKdigits(String num, int k) {
        List<Character> list = new ArrayList<>();
        StringBuilder ans = new StringBuilder();
        for (char c : num.toCharArray()) {
            int n = list.size();
            while (k > 0 && n > 0 && list.get(n - 1) > c) {
                list.remove(n - 1);
                k--;
                n--;
            }
            list.add(c);
        }
        while (k > 0) {
            list.remove(list.size() - 1);
            k--;
        }
        for (char c : list) {
            if (ans.length() == 0 && c == '0')
                continue;
            ans.append(c);
        }
        return ans.length() == 0 ? "0" : ans.toString();

    }
}