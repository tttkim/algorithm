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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int ci = 0;
        int total = 1;
        ListNode fast = head;
        ListNode post = new ListNode(-1, head);
        ListNode prev = post;
        
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            total += 2;
            prev = curr;
            curr = curr.next;
            ci++;
        }
        if (fast.next != null) {
            total++;
        }
        
        int offset = total - n;
        if (offset >= ci) {
            offset -= ci;
        } else {
            curr = head;
            prev = post;
        }
        System.out.println("curr : " + curr.val + " offset : " + offset);
        while (offset-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        
        return post.next;
    }
}