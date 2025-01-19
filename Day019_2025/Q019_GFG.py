class Solution:
    def rotate(self, head, k):
        # Edge case: if the list is empty or has only one node
        if not head or not head.next or k == 0:
            return head
        
        # Count the number of nodes in the list
        curr = head
        nodes = 1
        while curr.next:
            curr = curr.next
            nodes += 1
        
        # Adjust k to avoid unnecessary rotations
        k %= nodes
        if k == 0:
            return head
        
        # Make the list circular
        curr.next = head
        
        # Traverse to the (nodes - k)th node
        for _ in range(nodes - k):
            curr = curr.next
        
        # Update the head and break the loop
        head = curr.next
        curr.next = None
        
        return head
