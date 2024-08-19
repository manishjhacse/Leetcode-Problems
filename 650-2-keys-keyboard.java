class Solution {

    public int minSteps(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 2;
        }
        int arr[] = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 2;
        for (int i = 3; i <= n; i++) {
            int factor = i / 2;
            while (factor > 0) {
                if (i % factor == 0) {
                    int stepsTillFactor = arr[factor];
                    int pasteCount = (i / factor) - 1;
                    int copyCount = 1;
                    arr[i] = stepsTillFactor + copyCount + pasteCount;
                    break;
                } else {
                    factor--;
                }
            }

        }
        return arr[n];

    }
}
