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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tempa=list1;
        ListNode tempb=list1;
        ListNode temp2=list2;
        while(list2.next!=null)
        {
            list2=list2.next;
        }
        for(int i=0;i<a-1;i++)
        {
            tempa=tempa.next;
        }
        for(int i=0;i<b;i++)
        {
            tempb=tempb.next;
        }
        tempa.next=temp2;
        list2.next=tempb.next;
        return list1;

    }
}