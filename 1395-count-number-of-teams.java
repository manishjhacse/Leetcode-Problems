class Solution {
    public int numTeams(int[] rating) {
        int len = rating.length;
        int teams = 0;
        for (int midSoldier = 1; midSoldier < len - 1; midSoldier++) {
            int leftSmallerRating = 0;
            int rightGreaterRating = 0;
            for (int i = 0; i < midSoldier; i++) {
                if (rating[i] < rating[midSoldier]) {
                    leftSmallerRating++;
                }
            }
            for (int i = midSoldier + 1; i < len; i++) {
                if (rating[i] > rating[midSoldier]) {
                    rightGreaterRating++;
                }
            }
            teams += leftSmallerRating * rightGreaterRating;
            int leftGreaterRating = midSoldier - leftSmallerRating;
            int rightSmallerRating = len - midSoldier - 1 - rightGreaterRating;
            teams += leftGreaterRating * rightSmallerRating;

        }
        return teams;
    }
}