class Solution {
    public int maxLength(List<String> arr) {
        return solve(0, arr, "");
    }

    public int solve(int index, List<String> arr, String input) {

        if(index == arr.size()) {
            if (isValid(input)) {
                return input.length();
            }
            return 0;
        }
        int take = solve(index+1, arr, input+arr.get(index));
        int notTake = solve(index+1, arr, input);
        return Math.max(take, notTake);
    }

    public boolean isValid(String s) {
        int freq[] = new int[26];
        for(int i = 0; i < s.length(); i++) {
            int val = s.charAt(i) - 'a';
            freq[val]++;
            if(freq[val] > 1) return false;
        }
        return true;
    } 
}