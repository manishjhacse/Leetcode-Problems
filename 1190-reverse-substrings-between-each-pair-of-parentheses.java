class Solution {
    public void reverseString(StringBuilder str, int start, int end) {
        while (start <= end) {
            char ch = str.charAt(start);
            str.setCharAt(start, str.charAt(end));
            str.setCharAt(end, ch);
            start++;
            end--;
        }
    }

    public String reverseParentheses(String s) {
        StringBuilder str = new StringBuilder(s);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') {
                list.add(i);
            } else if (str.charAt(i) == ')') {
                int index = list.size() - 1;
                reverseString(str, list.get(index) + 1, i - 1);
                list.remove(index);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch != '(' && ch != ')') {
                result.append(ch);
            }
        }

        return result.toString();
    }
}