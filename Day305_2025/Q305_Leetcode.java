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
import java.util.*;

class Q305_Leetcode {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // Store nums in a HashSet for O(1) lookups
        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        // Dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (head != null) {
            if (!set.contains(head.val)) {  // keep node if not in nums
                current.next = head;
                current = current.next;
            }
            head = head.next;
        }

        current.next = null; // terminate list
        return dummy.next;
    }
}
