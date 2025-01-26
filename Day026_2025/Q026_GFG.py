class Solution:
    # Function to remove a loop in the linked list.
    def removeLoop(self, head):
        if not head or not head.next:
            return

        slow, fast = head, head

        # Detect loop using Floyd's Cycle-Finding Algorithm
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:  # Loop detected
                break
        else:
            # If no loop is found, return
            return

        # Move slow to head. Keep fast at the meeting point.
        slow = head

        # Special case when the loop starts at the head
        if slow == fast:
            while fast.next != slow:
                fast = fast.next
        else:
            while slow.next != fast.next:
                slow = slow.next
                fast = fast.next

        # Remove the loop
        fast.next = None
