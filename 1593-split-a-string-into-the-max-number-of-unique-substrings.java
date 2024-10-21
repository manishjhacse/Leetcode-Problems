class Solution {
    private int split(String s, Set<String> st) {
        if (s.length() == 0) {
            return st.size(); 
        }

        int mx = st.size(), n = s.length();
        
        for (int i = 1; i <= n; i++) {
            String first = s.substring(0, i); 
            if (!st.contains(first)) {
                st.add(first);
                mx = Math.max(mx, split(s.substring(i), st)); 
                st.remove(first); 
            }
        }

        return mx;
    }

    public int maxUniqueSplit(String s) {
        Set<String> st = new HashSet<>(); 
        return split(s, st); 
    }
}