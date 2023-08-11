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
    static int gcd(int a, int b)
    {
        int i,j;
        if (a < b)
            i = a;
        else
            i = b;
        for (j = i; j > 1; j--) {
            if (a % j == 0 && b % j == 0)
                return j;
        }
        return 1;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode temp=head;
        if(head==null)
        return head;
        while(temp.next!=null)
        {
            int a=temp.val;
            int b=temp.next.val;
            int g=gcd(a,b);
            ListNode newNode=new ListNode(g);
            newNode.next=temp.next;
            temp.next=newNode;
            temp=temp.next.next;
        }
        return head;
    }
}