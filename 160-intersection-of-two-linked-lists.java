/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempA=headA;
        ListNode tempB=headB;
        int lenA=0,lenB=0,diff;
        while(tempA!= null)
        {
            lenA++;
            tempA=tempA.next;
        }
        while(tempB!=null)
        {
            lenB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(lenA>lenB)
        {
            diff=lenA-lenB;
            while (diff > 0){
                tempA=tempA.next;
                diff--;
            }
        }
        else{
            diff=lenB-lenA;
             while (diff > 0){
                tempB=tempB.next;
                diff--;
            }
        }
        while(tempA!=null && tempB!=null)
        {
            if(tempA==tempB)
            {
                return tempA;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
        
    }
}