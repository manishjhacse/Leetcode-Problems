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
    public int pairSum(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null && fast.next!= null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        fast=head;
         ListNode curr=slow;
         ListNode prev=null;
         ListNode next=null;
         while(curr!=null)
         {
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
         }
         slow=prev;
         int max=Integer.MIN_VALUE;
         while(slow!=null){
            int s=slow.val+fast.val;
            max=Math.max(s, max);
            slow=slow.next;
            fast=fast.next;
         }
         return max;

    }
}