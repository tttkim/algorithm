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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode sentinel = new ListNode(Integer.MIN_VALUE, head);
        ListNode prev = sentinel;
        ListNode curr = sentinel;
        while (curr != null) {
            while (curr != null && prev.val == curr.val) {
                curr = curr.next;
            }
            prev.next = curr;
            prev = curr;
            if (curr != null)
                curr = curr.next;
        }
        return sentinel.next;
    }
}