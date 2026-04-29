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
    private ListNode reverse(ListNode head){
        if(head == null || head.next == null ) return head;
        ListNode curr = head, prev = null;
        while(curr!= null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    private int countNode(ListNode head){
        ListNode slow = head, fast = head;
        int cnt = 1;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast != null) cnt++;
        }
        
        if(fast == null) {
            return cnt * 2;
        }
        else if(fast.next == null) {
            return (cnt*2) - 1;
        }

        return cnt;
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        if(l1 == null) return l2;
        if(l2 == null) return l1;

        int cnt1 = countNode(l1), cnt2= countNode(l2);
        if(cnt2 > cnt1){
            ListNode temp = l1;
            l1 = l2;
            l2 = temp;
        }
        ListNode curr1 = l1, curr2 = l2, prev = null;
        System.out.println(cnt2);
        while(curr1 != null && curr2 != null){
            int n1 = curr1.val;
            int n2 = curr2.val;
            int rem = (n1 + n2 + carry)%10;
            carry = (n1 + n2 + carry)/10;

            curr1.val = rem;
            prev = curr1;
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        while(curr1 != null){
            int sum = curr1.val + carry;
            curr1.val = (sum)%10;
            carry = sum /10;
            prev = curr1;
            curr1 = curr1.next;
        }
        if(carry != 0){
            prev.next = new ListNode(carry);
        }
        return l1;
    }
}
