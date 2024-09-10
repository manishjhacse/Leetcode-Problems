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
    static int gcd(int i, int j) {
        int a, b;
        if (i > j) {
            a = i;
            b = j;
        } else {
            a = j;
            b = i;
        }
        if(b==0){
            return a;
        }
        return gcd(b,a%b);

    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode first = head;
        ListNode second = head.next;
        while (second != null) {
            int g = gcd(first.val, second.val);
            first.next = new ListNode(g);
            first.next.next = second;
            first = second;
            second = second.next;
        }
        return head;
    }
}