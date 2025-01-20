class Solution:
    def sortedMerge(self, head1, head2):
        # If one of the lists is empty, return the other
        if not head1:
            return head2
        if not head2:
            return head1
        
        # Dummy node to simplify the merge process
        dummy = Node(-1)
        curr = dummy

        # Merge the two lists
        while head1 and head2:
            if head1.data <= head2.data:
                curr.next = head1
                head1 = head1.next
            else:
                curr.next = head2
                head2 = head2.next
            curr = curr.next

        # Append any remaining nodes
        if head1:
            curr.next = head1
        if head2:
            curr.next = head2

        return dummy.next

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None