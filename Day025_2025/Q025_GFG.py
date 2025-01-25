class Solution:
    def findFirstNode(self, head):
        slow, fast = head, head

        # Detect loop using Floyd's cycle-finding algorithm
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            # Loop detected
            if slow == fast:
                slow = head

                # Find the first node of the loop
                while slow != fast:
                    slow = slow.next
                    fast = fast.next

                return slow # First node of the loop

        return None # No loop
