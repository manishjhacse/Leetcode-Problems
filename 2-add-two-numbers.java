<<<<<<< HEAD
import java.util.List;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head = new ListNode(0);
        ListNode temp = dummy_head;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int sum = 0;
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            temp.next = newNode;
            temp = temp.next;

        }

        return dummy_head.next;

=======
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
   
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy_head=new ListNode(0);
        ListNode temp=dummy_head;
        int carry=0;
        while(l1!=null || l2!=null)
        {
            int l1_val=(l1!=null)?l1.val:0;
            int l2_val=(l2!=null)?l2.val:0;
            int sum=l1_val+l2_val+carry;
            carry=sum/10;
            int node_val=sum%10;
            ListNode newNode= new ListNode(node_val);
            temp.next=newNode;
            if(l1!=null)
            l1=l1.next;
            if(l2!=null)
            l2=l2.next;
            temp=temp.next;
        }
        if(carry!=0)
        {
            ListNode newNode=new ListNode(carry);
            temp.next=newNode;
            temp=temp.next;
        }
        return dummy_head.next;
        
>>>>>>> 1e796e7697e088c826e12f5bfe9ce97b3aac737b
    }
}