class Solution {
    int totalBooks;
    int totalSelfWidth;
    int dp[][];

    private int returnMinHeight(int index, int[][] books, int remainingSelfWidht, int curSelfHeight) {
        if (index == totalBooks - 1) {
            if (books[index][0] <= remainingSelfWidht) {
                return Math.max(curSelfHeight, books[index][1]);
            } else {
                return curSelfHeight + books[index][1];
            }
        }
        if (dp[index][remainingSelfWidht] != 0) {
            return dp[index][remainingSelfWidht];
        }
        int bookOnSameSelf = Integer.MAX_VALUE;
        if (books[index][0] <= remainingSelfWidht) {
            bookOnSameSelf = returnMinHeight(index + 1, books, remainingSelfWidht - books[index][0],
                    Math.max(curSelfHeight, books[index][1]));
        }
        int bookOnNextSelf = curSelfHeight
                + returnMinHeight(index + 1, books, totalSelfWidth - books[index][0], books[index][1]);

        return dp[index][remainingSelfWidht] = Math.min(bookOnSameSelf, bookOnNextSelf);

    }

    public int minHeightShelves(int[][] books, int shelfWidth) {
        totalBooks = books.length;
        totalSelfWidth = shelfWidth;
        dp = new int[totalBooks][totalSelfWidth + 1];
        return returnMinHeight(0, books, shelfWidth, 0);
    }
}