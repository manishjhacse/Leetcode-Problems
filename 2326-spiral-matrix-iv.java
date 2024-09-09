/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] ans = new int[m][n];
        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = head == null ? -1 : head.val;
                head = head != null ? head.next : null;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = head == null ? -1 : head.val;
                head = head != null ? head.next : null;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = head == null ? -1 : head.val;
                    head = head != null ? head.next : null;
                }
                bottom--;
            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = head == null ? -1 : head.val;
                    head = head != null ? head.next : null;
                }
                left++;
            }
        }
        return ans;

    }
}