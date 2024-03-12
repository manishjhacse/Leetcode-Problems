import java.util.HashMap;

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
    public ListNode removeZeroSumSublists(ListNode head) {
        HashMap<Integer, ListNode> map = new HashMap<>();
        int prefixSum = 0;
        ListNode dummyHead = new ListNode(0, head);
        ListNode temp = dummyHead;
        while (temp != null) {
            prefixSum += temp.val;
            map.put(prefixSum, temp);
            temp = temp.next;
        }
        prefixSum = 0;
        temp = dummyHead;
        while (temp != null) {
            prefixSum += temp.val;
            temp.next = map.get(prefixSum).next;
            temp = temp.next;
        }
        return dummyHead.next;
    }
}