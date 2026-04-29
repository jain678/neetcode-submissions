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
        ListNode curr = head, prev = null;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev= curr;
            curr = nxt;
        }
        return prev;
    } 
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return ;
        int cnt = 0;
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            cnt++;
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode h1 = head, h2 = reverse(slow.next), temp = null;
        slow.next = null;
        while(h2!=null && h1 != null){
            ListNode temp1 = h1.next, temp2 = h2.next;
            h1.next = h2;
            h2.next = temp1;
            h1 = temp1;
            h2 = temp2;
        }
        return ;

    }
}
