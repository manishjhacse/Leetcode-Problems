import java.util.List;

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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode current=head;
        ListNode start=head; 
        ListNode prev=head;
        ListNode nextptr=head;
        ListNode temp=head;
        if(left==right)
        {
            return head;
        }
        for(int i=1;i<left-1;i++)
        {
            start=start.next;
        }
        for(int i=1;i<left;i++)
        {
            current=current.next;
        }
        for(int i=0;i<right;i++)
        {
            nextptr=nextptr.next;
            prev=prev.next;
            temp=temp.next;
        }
        while(current!=temp)
        {
            nextptr=current.next;
            current.next=prev;
            prev=current;
            current=nextptr;
        }
        if(left==1)
        {
            head=prev;
            return head;
        }
        start.next=prev;
        return head;
    }
}