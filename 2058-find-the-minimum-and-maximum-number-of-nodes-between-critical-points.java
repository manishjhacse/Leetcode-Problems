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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int firstCP = -1;
        int prevCP = -1;
        int index = 1;
        ListNode prev = head;
        ListNode current = head.next;
        int ans[] = new int[2];
        ans[0] = Integer.MAX_VALUE;
        while (current.next != null) {
            ListNode next = current.next;
            if ((next.val > current.val && prev.val > current.val)
                    || (next.val < current.val && prev.val < current.val)) {
                if (prevCP == -1) {
                    firstCP = index;
                    prevCP = index;
                } else {
                    ans[0] = Math.min(ans[0], index - prevCP);
                    prevCP = index;
                }
            }
            prev = prev.next;
            current = current.next;
            index++;
        }
        if (firstCP != -1 && ans[0] != Integer.MAX_VALUE) {
            ans[1] = prevCP - firstCP;
        } else {
            ans[0] = ans[1] = -1;
        }
        return ans;

    }
}