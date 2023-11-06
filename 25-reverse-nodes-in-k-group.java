/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int size=0;
        ListNode temp=head;
        while(head!=null)
        {
            size++;
            temp=temp.next;
        }
        temp=head;
        if(size%k==0)
        {

        }

    }
}