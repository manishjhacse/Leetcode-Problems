import java.util.ArrayList;
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
    public boolean isPalindrome(ListNode head) {
        ListNode newNode=new ListNode();
        List<Integer> arr=new ArrayList<>();
        ListNode temp=head;
        while(temp!=null)
        {
            arr.add(temp.val);
            temp=temp.next;
        }
        int n=arr.size();
        int lb=0,ub=n-1;
        while(lb<ub)
        {
            if(!arr.get(lb).equals(arr.get(ub)))
            {
                return false;
            }
            lb++;
            ub--;
        }
        return true;
        
    }
}