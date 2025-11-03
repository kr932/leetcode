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
    public ListNode insertionSortList(ListNode head) {
        if (head == null) return null;

        // Dummy node to act as the head of the sorted portion
        ListNode dummy = new ListNode(0);
        ListNode curr = head;

        while (curr != null) {
            // Save the next node to process
            ListNode next = curr.next;

            // Find correct position to insert curr in the sorted part
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }

            // Insert curr node between prev and prev.next
            curr.next = prev.next;
            prev.next = curr;

            // Move to the next node in the original list
            curr = next;
        }

        return dummy.next;
    }
}
