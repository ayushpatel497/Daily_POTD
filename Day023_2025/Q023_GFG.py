class Node:
    def __init__(self, x):
        self.data = x
        self.next = None
        self.random = None

class Solution:
    def cloneLinkedList(self, head):
        if not head:
            return None

        # Step 1: Create new nodes and interweave them with the original list
        curr = head
        while curr:
            new_node = Node(curr.data)
            new_node.next = curr.next
            curr.next = new_node
            curr = new_node.next

        # Step 2: Assign random pointers for the newly created nodes
        curr = head
        while curr:
            if curr.random:
                curr.next.random = curr.random.next
            curr = curr.next.next

        # Step 3: Detach the original list and the cloned list
        curr = head
        new_head = curr.next
        new_curr = new_head
        while curr:
            curr.next = new_curr.next
            curr = curr.next
            if curr:
                new_curr.next = curr.next
            new_curr = new_curr.next

        return new_head
