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
    public ListNode mergeNodes(ListNode head) {
        ListNode temp1=head;
        ListNode temp2=temp1;
        head=head.next;
        int sum=0;
        while(head!=null)
        {
            if(head.val!=0)
            {
                sum+=head.val;
            }
            else{
                temp1=temp1.next;
                temp1.val=sum;
                sum=0;
            }
            head=head.next;
        }
        temp1.next=null;
        return temp2.next;
    }
}