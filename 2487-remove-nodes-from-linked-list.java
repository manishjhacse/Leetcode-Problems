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

    public ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        ListNode nextptr = null;
        while (current != null) {
            nextptr = current.next;
            current.next = prev;
            prev = current;
            current = nextptr;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {

        head = reverse(head);

        ListNode curr = head, prv = null;
        int mx = head.val;
        while (curr != null) {
            mx = Math.max(mx, curr.val);
            if (mx > curr.val) {
                prv.next = prv.next.next;
            } else {
                prv = curr;
            }
            curr = curr.next;
        }

        head = reverse(head);

        return head;

    }
}