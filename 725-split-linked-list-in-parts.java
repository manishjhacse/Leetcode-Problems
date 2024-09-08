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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        temp = head;
        ListNode[] ans = new ListNode[k];
        int n = size / k;
        int rem = size % k;
        for (int i = 0; i < k; i++) {
            int count = n;
            if (rem > 0) {
                count++;
                rem--;
            }
            ans[i] = temp;
            while (temp != null && count > 1) {
                temp = temp.next;
                count--;
            }
            if (temp != null) {
                ListNode cur = temp;
                temp = temp.next;
                cur.next = null;
            }
        }
        return ans;
    }
}