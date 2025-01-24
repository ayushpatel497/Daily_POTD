class Solution:
    # Function to check if the linked list has a loop.
    def detectLoop(self, head):
        if not head:
            return False

        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True  # Loop detected

        return False  # No loop detected


# Definition for the Node class
class Node:
    def __init__(self, val):
        self.data = val
        self.next = None
