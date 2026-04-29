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
        if(head == null || head.next == null) return head;
        ListNode prev = null, curr = head;
        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return head;

        ListNode h1 = reverse(head);
        if(n == 1){
            return reverse(h1.next);
        }
        int cnt = 1;
        ListNode curr = h1, prev = null;
        while(curr != null){
            if(cnt == n){
                prev.next = curr.next;
                return reverse(h1);
            }
            prev = curr;
            curr = curr.next;

            cnt++;
        }
        return head;
    }
}
