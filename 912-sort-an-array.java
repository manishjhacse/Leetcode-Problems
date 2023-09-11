class Solution {
    public static void mergeArray(int arr[], int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - (mid + 1) + 1;

        int left_subArray[] = new int[n1];
        int right_subArray[] = new int[n2];
        for (int i = 0; i < n1; i++) {
            left_subArray[i] = arr[i + l];
        }
        for (int i = 0; i < n2; i++) {
            right_subArray[i] = arr[i + mid + 1];
        }
        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left_subArray[i] < right_subArray[j]) {
                arr[k] = left_subArray[i];
                i++;
            } else {
                arr[k] = right_subArray[j];
                j++;
            }
            k++;
        }
        while (i < n1) {
            arr[k] = left_subArray[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = right_subArray[j];
            j++;
            k++;
        }
    }

    public static void mergesort(int[] arr, int i, int j) {
        if (i < j) {
            int mid = i + (j - i) / 2;
            mergesort(arr, i, mid);
            mergesort(arr, mid + 1, j);
            mergeArray(arr, i, mid, j);
        }
    }

    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }
}