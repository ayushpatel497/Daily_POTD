class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

class Solution:
    def countNodesInLoop(self, head):
        if not head:
            return 0

        slow = head
        fast = head

        # Detect loop
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                # Loop detected; count its length
                count = 1
                temp = slow.next
                while temp != slow:
                    count += 1
                    temp = temp.next
                return count

        return 0  # No loop
